package com.alisha.wddily;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.alisha"})
@MapperScan(basePackages = {"com.alisha.wddily.user.dao.mapper"})
public class WddilyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WddilyUserApplication.class, args);
    }

}
