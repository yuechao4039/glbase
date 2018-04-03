package com.hualala.interfaces.exhandler;

import com.hualala.interfaces.general.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Slf4j
public class HualalaExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        log.error(ex.getMessage(), ex);
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);


        BaseResp baseResp = new BaseResp();
        try (PrintWriter printWriter = response.getWriter()) {
            if (ex instanceof HualalaException) {
                HualalaException hualalaException = (HualalaException)ex;

                baseResp.setResultCode(hualalaException.getResultcode());
                baseResp.setResultMsg(hualalaException.getMessage());
                printWriter.write(baseResp.toString());
            } else {
                baseResp.setResultCode(MsgDefine.getExceptionMsgCode());
                baseResp.setResultMsg(ex.getMessage());
                printWriter.write(baseResp.toString());
            }
        } catch (IOException e) {
           log.error(e.getMessage(), e);
        }

        return new ModelAndView();
    }
}