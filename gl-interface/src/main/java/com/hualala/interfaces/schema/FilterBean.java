package com.hualala.interfaces.schema;


import lombok.Data;

@Data
public class FilterBean {

	public static final String ATTR_ID = "uri";
	public static final String ATTR_SERVICE = "service";
    public static final String ATTR_IMPL_NAME = "implName";
	public static final String ATTR_METHOD = "method";

	private String service;
	private String method;
	private String implName;



}
