package com.hualala.interfaces.exhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teco")
public class TestController {
    @RequestMapping(value = "/testexc", method = RequestMethod.GET)
    @ResponseBody
    public void testException()  {
        throw new HualalaException("100001");
    }
}