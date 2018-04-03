package com.hualala.interfaces.general;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageResp<E> extends BaseResp<E> {


    private PageInfoResponsePojo pageInfo = new PageInfoResponsePojo();

    /**
     * 设置每页多少条数据
     */
    public PageResp<E> setSize(Integer size) {
        this.pageInfo.setSize(size);
        return this;
    }


    /**
     * 设置第几页
     */
    public PageResp<E> setNum(Integer num) {
        this.pageInfo.setNum(num);
        return this;
    }

    /**
     * 设置总页数
     */
    public PageResp<E> setTotal(Integer total) {
        this.pageInfo.setTotal(total);
        return this;
    }

    /**
     * 设置总行数
     */
    public PageResp<E> setRows(Integer rows) {
        this.pageInfo.setRows(rows);
        return this;
    }




}
