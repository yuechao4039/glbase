package com.hualala.interfaces.general;


import lombok.*;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;


@Data
@ToString(callSuper = false)
public class BaseReq<T> {

    private HeaderRequestPojo header;


    private T data;



}
