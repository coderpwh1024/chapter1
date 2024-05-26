package com.coderpwh.web;

import com.coderpwh.client.ProviderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author coderpwh
 */
@RestController
public class ConsumerController {

    @Resource
    private ProviderClient providerClient;

    @GetMapping("/hi-feign")
    public String hiFeign() {
        return providerClient.hi("feign");
    }
}
