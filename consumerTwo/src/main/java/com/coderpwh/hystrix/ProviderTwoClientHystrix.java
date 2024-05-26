package com.coderpwh.hystrix;

import com.coderpwh.client.ProviderTwoClient;
import org.springframework.stereotype.Component;

@Component
public class ProviderTwoClientHystrix implements ProviderTwoClient {

    @Override
    public String getUserInfo() {
        return "sorry,服务不可用呀!";
    }

}
