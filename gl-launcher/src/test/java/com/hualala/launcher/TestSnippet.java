package com.hualala.launcher;


import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class TestSnippet {


    @Test
    public void snippet() {
        String CONFIG_LOCATION_DELIMITERS = ",; \t\n";

        String aa = "classpath:spring.xml   classpath:spring-main-mybatis.xml, classpath:spring-minor-mybatis.xml,\n" +
                "            classpath:api/*.xml";

        Arrays.asList(StringUtils.tokenizeToStringArray(aa, CONFIG_LOCATION_DELIMITERS)).forEach(x -> System.out.println(x));
    }


}
