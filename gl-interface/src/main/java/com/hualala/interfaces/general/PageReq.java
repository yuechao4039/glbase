package com.hualala.interfaces.general;

import com.alibaba.fastjson.JSONObject;
import com.hualala.interfaces.student.StudentQueryReq;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PageReq<T> extends BaseReq<T> {

    private PageInfoRequestPojo pageInfo;

    public Integer getSize() {
        return this.pageInfo.getSize();
    }

    public Integer getNum() {
        return this.pageInfo.getNum();
    }

    public static void main(String[] args) {
        String aa = "{\"pageInfo\":{\"size\":10,\"num\":2},\"header\":{\"trcid\":\"d1338c70-19ac-40e1-a459-681c6f90e733\",\"debug\":true},\"data\":{\"shopID\":123,\"shopName\":\"哗啦啦测试店\",\"accountInfo\":[{\"accountID\":\"9183dkk1-1lljj11-j1k2-12\",\"accountName\":\"应收账款\"},{\"accountID\":\"9183dkk1-1lljj11-j1k2-12\",\"accountName\":\"应收账款\"}]}}";
        PageReq a = JSONObject.parseObject(aa, PageReq.class);
        System.out.println(a);
    }
}
