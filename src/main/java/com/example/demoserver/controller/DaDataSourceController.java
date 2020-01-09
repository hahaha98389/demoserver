package com.example.demoserver.controller;

import com.example.demoserver.dao.interfaces.da2.MoneyMapper;
import com.example.demoserver.dao.interfaces.da3.UserMapper;
import com.example.demoserver.dao.po.da2.Money;
import com.example.demoserver.dao.po.da2.MoneyExample;
import com.example.demoserver.dao.po.da3.User;
import com.example.demoserver.dao.po.da3.UserExample;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/test")
@RestController
public class DaDataSourceController {


    @Autowired
    MoneyMapper moneyMapper;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/getMoney")
    public List<Money> getMoney(){
        MoneyExample moneyExample = new MoneyExample();
        return moneyMapper.selectByExample(moneyExample);

    }

    @RequestMapping("/getUser")
    public List<User> getUser(){

        UserExample userExample = new UserExample();
        return userMapper.selectByExample(userExample);
    }



}
