//package com.hualala;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.hualala.interfaces.general.BaseResp;
//import com.hualala.interfaces.general.HeaderRequestPojo;
//import com.hualala.interfaces.general.PageInfoRequestPojo;
//import com.hualala.interfaces.general.PageReq;
//import com.hualala.interfaces.student.StudentQueryReq;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.beans.BeanUtils;
//import org.springframework.util.ClassUtils;
//import org.springframework.util.ReflectionUtils;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@Getter
//@Setter
//@ToString(callSuper = true)
//public class StudentQueryReqTest {
//
//
//
//    private List<Account> accountInfo = new ArrayList<Account>();
//
//    private String shopID;
//
//    private String shopName;
//
//
//
//    public static void main(String[] args) {
//        String str = "{\"pageInfo\":{\"size\":40,\"num\":1}," +
//                "\"header\":{\"trcid\":\"d1338c70-19ac-40e1-a459-681c6f90e733\",\"debug\":true}," +
//                "\"data\":{\"shopID\":123,\"shopName\":\"哗啦啦测试店\"," +
//                "\"accountInfo\":[{\"accountID\":\"9183dkk1-1lljj11-j1k2-12\",\"accountName\":\"应收账款\"}," +
//                "{\"accountID\":\"9183dkk1-1lljj11-j1k2-12\",\"accountName\":\"应收账款\"}]}}";
//        JSONObject jobject = JSONObject.parseObject(str);
//        PageInfoRequestPojo pageInfo = jobject.getObject("pageInfo", PageInfoRequestPojo.class);
//        HeaderRequestPojo header = jobject.getObject("header", HeaderRequestPojo.class);
//
//
//        PageReq<StudentQueryReqTest> pagesReq = new PageReq<StudentQueryReqTest>();
//        pagesReq.setPageInfo(pageInfo);
//        pagesReq.setHeader(header);
//
//        Optional<Method> optional = Arrays.asList(ReflectionUtils.getAllDeclaredMethods(StudentQueryReqTest.class))
//                .stream()
//                .filter(me -> {
//                    if (me.getName().equals("select")){
//                        return true;
//                    }
//                    return false;
//                }).findFirst();
//        Method method = optional.get();
//
//
//        Type[] types = method.getGenericParameterTypes();
//        if (types[0] instanceof ParameterizedType) {
//            ParameterizedType pt = (ParameterizedType)types[0];
//            Type[] typeArguments = pt.getActualTypeArguments();
//            System.out.println(typeArguments[0]);
//
//            pagesReq.setData((StudentQueryReqTest)jobject.getObject("data", (Class)typeArguments[0]));
//            System.out.println(pagesReq);
//        }
////        String type = types[0].getTypeName().substring(types[0].getTypeName().indexOf("<") + 1, types[0].getTypeName().indexOf(">"));
////        System.out.println(type);
////        Class cls = ClassUtils.resolveClassName(type, ClassUtils.getDefaultClassLoader());
//
////        System.out.println(cls);
//    }
//
//    public BaseResp select(PageReq<StudentQueryReqTest> studentQueryRequest) {
//        System.out.println(JSON.toJSONString(studentQueryRequest));
//        return null;
//    }
//
//}
//
//@lombok.Data
//class Account {
//
//    private String accountID;
//
//    private String accountName;
//}
