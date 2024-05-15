package com.coderpwh.com.coderpwh.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getUserInfo() {
        return "This is User Service My name is Jack";

    }


}
