package com.hualala.interfaces.general;

import lombok.Data;

@Data
public class HeaderResponsePojo {

    private String trcid;

    private long time = System.currentTimeMillis();

    private String errorDetail;

}
