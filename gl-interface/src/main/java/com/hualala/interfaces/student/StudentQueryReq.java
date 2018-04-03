package com.hualala.interfaces.student;

import com.alibaba.fastjson.JSONObject;
import com.hualala.interfaces.general.BaseReq;
import com.hualala.interfaces.general.PageReq;
import lombok.*;

import javax.security.auth.login.AccountException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class StudentQueryReq {

    private Data data;


    private List<Account> accountInfo = new ArrayList<Account>();

    private String shopID;

    private String shopName;


    public static void main(String[] args) {
        String str = "{\"pageInfo\":{\"size\":40,\"num\":1},\"header\":{\"trcid\":\"d1338c70-19ac-40e1-a459-681c6f90e733\",\"debug\":true},\"data\":{\"shopID\":123,\"shopName\":\"哗啦啦测试店\",\"accountInfo\":[{\"accountID\":\"9183dkk1-1lljj11-j1k2-12\",\"accountName\":\"应收账款\"},{\"accountID\":\"9183dkk1-1lljj11-j1k2-12\",\"accountName\":\"应收账款\"}]}}";

        StudentQueryReq req = JSONObject.parseObject(str, new StudentQueryReq().getClass());
        req.getClass().getTypeParameters();
        System.out.println(req);
    }

}

@lombok.Data
class Account {

    private String accountID;

    private String accountName;
}