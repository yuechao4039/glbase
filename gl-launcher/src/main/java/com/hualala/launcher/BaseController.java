package com.hualala.launcher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hualala.interfaces.exhandler.HualalaException;
import com.hualala.interfaces.general.BaseReq;
import com.hualala.interfaces.general.BaseResp;
import com.hualala.interfaces.general.HeaderRequestPojo;
import com.hualala.interfaces.general.PageInfoRequestPojo;
import com.hualala.interfaces.schema.FilterBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ClassUtils;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.*;

@Slf4j
public class BaseController implements ApplicationContextAware {

    @Autowired
    protected ApplicationContext appContext;

    @Autowired
    private RequestFilter requestFilter;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }

    protected HttpServletRequest getHttpRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpServletResponse getHttpResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public BaseResp exec(HttpServletRequest request, HttpServletResponse httpResponse) {
        BaseResp baseResp = new BaseResp();
        FilterBean filterBean = this.appContext.getBean(request.getRequestURI(), FilterBean.class);
        if (null == filterBean) {
            // 100001=请求路径未配置[100001]
            throw new HualalaException("100001");
        }
        Class<?> cls = ClassUtils.resolveClassName(filterBean.getService(), ClassUtils.getDefaultClassLoader());

        Optional<Method> optional = Arrays.asList(ReflectionUtils.getAllDeclaredMethods(cls))
                .stream()
                .filter(me -> {
                    if (me.getName().equals(filterBean.getMethod())) {
                        return true;
                    }
                    return false;
                }).findFirst();
        Method method = optional.get();

        Object req = this.assembleRequest(method, request);


        Object object = appContext.getBean(filterBean.getImplName(), cls);

        baseResp = requestFilter.doFilter(method, object, req);
//        baseResp = (BaseResp) ReflectionUtils.invokeMethod(method, object, new Object[]{req});

        return baseResp;
    }


    public Object assembleRequest(Method method, HttpServletRequest request) {
        final Map<String, String> map = new HashMap<String, String>();
        log.info("requestURI={}, method={}, contentType={}", request.getRequestURI(), request.getMethod(), request.getContentType());

        Class<?> cls = method.getParameterTypes()[0];

        if (RequestMethod.GET.name().equals(request.getMethod()) ||
                RequestMethod.POST.name().equals(request.getMethod())) {

            if (MimeTypeUtils.APPLICATION_JSON_VALUE.equals(request.getContentType())) {
                return getRequestPayLoad(request, cls, method);
            } else if (MimeTypeUtils.APPLICATION_FORM_URLENCODED_VALUE.equals(request.getContentType())) {
                return getRequestParameters(request, cls);
            }
        } else {
        }
        return new Object();
    }

    private Object getRequestPayLoad(HttpServletRequest request, Class cls, Method method) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), Charset.defaultCharset()))) {
            String str;
            StringBuilder sb = new StringBuilder();
            while (null != (str = br.readLine())) {
                sb.append(str);
            }

            log.info("requestPayload={}", sb.toString());
            JSONObject jsonObject = JSON.parseObject(sb.toString());

            Object reqobj = BeanUtils.instantiate(cls);

            getAllDeclaredFields(cls).forEach(field -> {
                ReflectionUtils.makeAccessible(field);
                if (field.getName().equals("data")) {
                    Type[] types = method.getGenericParameterTypes();
                    Class dataCls = null;
                    if (types.length == 1) {
                        if (types[0] instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType)types[0];
                            dataCls = (Class)parameterizedType.getActualTypeArguments()[0];
                        }
                    }
                    ReflectionUtils.setField(field, reqobj, jsonObject.getObject(field.getName(), dataCls));
                } else {
                    ReflectionUtils.setField(field, reqobj, jsonObject.getObject(field.getName(), field.getType()));
                }

            });
            return  reqobj;
        } catch (IOException e) {
           log.error(e.getMessage(), e);
        }
        return new BaseReq();
    }

    private List<Field> getAllDeclaredFields(Class cls) {
        List<Field> fieldList = new ArrayList<Field>();
        Field[] fields = cls.getDeclaredFields();
        fieldList.addAll(Arrays.asList(fields));
        if (null != cls.getSuperclass()) {
            fieldList.addAll(getAllDeclaredFields(cls.getSuperclass()));
        }
        return fieldList;
    }


    private BaseReq getRequestParameters(HttpServletRequest request, Class cls) {
        Object reqobj = BeanUtils.instantiate(cls);
        Enumeration<String> en = request.getParameterNames();

        Map<String, String> map = new HashMap<>();
        while (en.hasMoreElements()) {
            String next = en.nextElement();
            map.put(next, request.getParameter(next));
        }
        Arrays.asList(cls.getDeclaredFields()).forEach(field -> {
            if (map.containsKey(field.getName())) {
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, reqobj, map.get(field.getName()));
            }
        });
        return (BaseReq) reqobj;
    }
}
