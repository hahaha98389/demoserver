package com.example.demoserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demoserver.dao.interfaces")
@SpringBootApplication
public class DemoserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoserverApplication.class, args);
    }

}
