package com.hualala.interfaces.general;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hualala.interfaces.exhandler.MsgDefine;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class BaseResp<E> {

    private String resultCode = MsgDefine.getSuccessMsgCode();

    private String resultMsg = MsgDefine.getSuccessMsg();

    private HeaderResponsePojo header = new HeaderResponsePojo();

    private E data;


    public void setTrcId(String trcId) {
        this.header.setTrcid(trcId);
    }

    public void setErrorDetail(String errorDetail) {
        this.header.setErrorDetail(errorDetail);
    }


    @Override
    public String toString() {
        return JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}
