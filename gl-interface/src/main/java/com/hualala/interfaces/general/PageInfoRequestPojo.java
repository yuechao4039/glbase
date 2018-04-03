package com.hualala.interfaces.general;


import lombok.Data;

@Data
public class PageInfoRequestPojo {


    /**
     * 每页多少条数据
     */
    private Integer size = 10;

    /**
     * 第几页
     */
    private Integer num = 1;
}
