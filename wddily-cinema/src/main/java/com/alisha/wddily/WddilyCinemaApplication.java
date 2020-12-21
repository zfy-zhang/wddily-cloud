package com.alisha.wddily;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.alisha"})
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.alisha.wddily.cinema.dao"})
public class WddilyCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WddilyCinemaApplication.class, args);
	}

}
