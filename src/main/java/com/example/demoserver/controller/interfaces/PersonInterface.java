package com.example.demoserver.controller.interfaces;


import com.example.demoserver.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Person")
public interface PersonInterface {
    @GetMapping("/getPerson")
    Person getPerson();

}
