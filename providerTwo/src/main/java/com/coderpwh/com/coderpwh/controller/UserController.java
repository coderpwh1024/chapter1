package com.coderpwh.com.coderpwh.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getUserInfo() {

        try {
             // 休眠10s
             Thread.sleep(300);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "This is User Service My name is Jack";

    }


}
