package com.coderpwh.web;


import com.coderpwh.client.ProviderTwoClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private ProviderTwoClient providerTwoClient;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getUserInfo() {
        return providerTwoClient.getUserInfo();
    }

}
