package com.example.demoserver.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//多数据源测试
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    @Qualifier("da2JdbcTemplate")
    private JdbcTemplate marketTemplate;

    @Autowired
    @Qualifier("da3JdbcTemplate")
    private JdbcTemplate tradeTemplate;

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/getMarketUser")
    public String getPGUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String query = " select * from user where id='7'";
        try {
            // 每条记录对应一个Map，当只返回一条数据时用queryForMap即可
            map = marketTemplate.queryForMap(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Marke Data: " + map.toString();
    }

    @GetMapping(value = "/getTradeUser")
    public String getMYUser() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String query = " select * from user";
        try {
            // 如果返回多条数据需要用queryForList方法，并用一个泛型为Map的List来接收
            list = tradeTemplate.queryForList(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Trade Data: " + list.toString();
    }
}
