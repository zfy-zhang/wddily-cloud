package com.alisha.wddily.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Slf4j
@RestController
public class ProviderController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/provider/sayHello")
    public String providerSayHello(String message) {
        log.error("provider sayHello port:{}, message:{}", port, message);
        return "Provider sayHello port: " + port + " message: " + message;
    }

}
