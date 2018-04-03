package com.hualala.launcher;


import com.hualala.interfaces.general.BaseResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(value = {"/gl"})
public class ApiBaseController extends BaseController {


    @RequestMapping(value = {"/*"})
    public ResponseEntity<BaseResp> execute(HttpServletRequest httpReq, HttpServletResponse httpResponse) {
        BaseResp baseResp = super.exec(httpReq, httpResponse);
        return new ResponseEntity<BaseResp>(baseResp, HttpStatus.OK);
    }


}
