package com.hualala.interfaces.user;


import com.hualala.interfaces.general.BaseReq;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class UserUpdateReq extends BaseReq{

    private Integer id;


    private String username;

    private Integer age;


}