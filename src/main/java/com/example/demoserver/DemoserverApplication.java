package com.example.demoserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//SpringbootApplication 禁止加载自身对DataSource的扫描
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@MapperScan("com.example.demoserver.dao.interfaces")
//@SpringBootApplication
public class DemoserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoserverApplication.class, args);
    }


}
