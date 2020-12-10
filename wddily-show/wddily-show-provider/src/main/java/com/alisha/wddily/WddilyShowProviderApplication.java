package com.alisha.wddily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WddilyShowProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WddilyShowProviderApplication.class, args);
    }

}
