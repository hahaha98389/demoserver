package com.example.demoserver.controller;


import com.example.demoserver.utils.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RequestMapping("/redis")
@RestController
public class RedisTestController {


    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/set")
    public Boolean set(){
        Boolean b = redisUtil.set("name","guoshaowei");
        return b;
    }

    @RequestMapping("/get")
    public String get(){
        String a = (String)redisUtil.get("name");
        return a;
    }


}
