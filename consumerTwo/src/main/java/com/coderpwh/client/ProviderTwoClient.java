package com.coderpwh.client;


import com.coderpwh.hystrix.ProviderTwoClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "providerTwo", fallback = ProviderTwoClientHystrix.class)
public interface ProviderTwoClient {


    /***
     * 请求用户信息
     * @return
     */
    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    String getUserInfo();
}
