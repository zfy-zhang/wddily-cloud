package com.alisha.wddily.service.impl;

import com.alisha.wddily.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final RestTemplate restTemplate;

    private LoadBalancerClient loadBalancerClient;

    @Autowired
    public ConsumerServiceImpl(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }

    @Override
    public String sayHello(String message) {

        ServiceInstance serviceInstance = loadBalancerClient.choose("hello-service-provider");
        String hostname = serviceInstance.getHost();
        int port = serviceInstance.getPort();

//        String hostname = "localhost";
//        int port = 7101;
        String uri = "provider/sayHello?message=" + message;
        String url = "http://" + hostname + ":" +port + uri;

        return restTemplate.getForObject(url, String.class);
    }
}
