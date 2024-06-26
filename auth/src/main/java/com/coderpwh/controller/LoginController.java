package com.coderpwh.controller;


import com.coderpwh.model.LoginVal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {


    /***
     * 登录
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public LoginVal login(HttpServletRequest httpServletRequest) {
        return  (LoginVal)httpServletRequest.getAttribute("login_message");
    }


}
