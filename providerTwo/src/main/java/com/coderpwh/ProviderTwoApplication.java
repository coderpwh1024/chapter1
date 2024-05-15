package com.coderpwh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages ={"com.coderpwh"})
@EnableDiscoveryClient
public class ProviderTwoApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProviderTwoApplication.class, args);
    }

}
