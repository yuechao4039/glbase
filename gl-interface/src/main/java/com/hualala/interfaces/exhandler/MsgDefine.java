package com.hualala.interfaces.exhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class MsgDefine {

    private static Properties props = new Properties();

    static {
        loadProps();
    }

    synchronized static private void loadProps() {
//        ClassPathResource resource = new ClassPathResource("msgdefine.properties", MsgDefine.class);
//        PropertiesLoaderUtils.loadProperties(new Properties(), resource);
        try (InputStream in = ClassUtils.getDefaultClassLoader().getResourceAsStream("msgdefine.properties")){

            props.load(in);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        log.info(props.toString());
    }

    public static String getProperty(String key) {
        return props.getProperty(key, "msgcode does not exists");
    }

    public static String getProperty(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }

    private final static String SUCCESS_MSG_CODE = "000";
    public static String getSuccessMsgCode() {
        return SUCCESS_MSG_CODE;
    }

    private final static String SUCCES_MSG = "执行成功";
    public static String getSuccessMsg() {
        return SUCCES_MSG;
    }

    public static String getExceptionMsgCode() {
        return "100000";
    }

    public static String getSuccessMsgDefine() {
        return props.getProperty(getSuccessMsgCode());
    }
}