package com.hualala.launcher;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hualala.interfaces.exhandler.HualalaException;
import com.hualala.interfaces.general.BaseReq;
import com.hualala.interfaces.general.BaseResp;
import com.hualala.interfaces.general.PageReq;
import com.hualala.interfaces.general.PageResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

@Service
@Slf4j
public class RequestFilter {

    public BaseResp doFilter(Method method, Object object, Object reqObj) {

        BaseResp baseResp = new BaseResp();

        Object respObj = ReflectionUtils.invokeMethod(method, object, new Object[]{reqObj});
        if (PageReq.class.isAssignableFrom(reqObj.getClass())) {

            if (PageResp.class.isAssignableFrom(respObj.getClass())) {

            } else {
                // 100002=请求与响应类型不匹配[100002]
                throw new HualalaException("100002");
            }
            PageReq req = (PageReq)reqObj;
            PageResp pageResp = (PageResp)respObj;
            pageResp.setSize(req.getSize());
            pageResp.setNum(req.getNum());
            pageResp.setTotal((pageResp.getPageInfo().getRows() + req.getSize() - 1) / req.getSize());
            pageResp.setTrcId(req.getHeader().getTrcid());
            return (BaseResp)respObj;
        } else {
            BaseReq baseReq = (BaseReq)reqObj;
            baseResp = (BaseResp)respObj;
            baseResp.setTrcId(baseReq.getHeader().getTrcid());
        }

        return baseResp;
    }
}
