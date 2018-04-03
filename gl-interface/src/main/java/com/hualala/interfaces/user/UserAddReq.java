package com.hualala.interfaces.user;


import com.hualala.interfaces.general.BaseReq;
import lombok.Data;

@Data
public class UserAddReq extends BaseReq{

    private Integer id;


    private String username;

    private Integer age;


}