package com.hualala.interfaces.general;


import lombok.Data;

@Data
public class PageInfoResponsePojo {

    /**
     * 每页多少条数据
     */
    private Integer size = 20;

    /**
     * 第几页
     */
    private Integer num = 1;

    /**
     * 总页数
     */
    private Integer total;

    /**
     * 总行数
     */
    private Integer rows;
}
