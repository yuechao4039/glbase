package com.hualala.interfaces.exhandler;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HualalaException extends RuntimeException {
    private String resultcode;
    private String resultMessage;

    public HualalaException() {
    }

    public HualalaException(String code) {
        super(MsgDefine.getProperty(code));
        this.resultcode = code;
        this.resultMessage = MsgDefine.getProperty(code);

    }


}