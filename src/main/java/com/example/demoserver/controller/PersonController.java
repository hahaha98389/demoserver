package com.example.demoserver.controller;

import com.example.demoserver.bean.Person;
import com.example.demoserver.service.interfaces.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Person")
@RestController
public class PersonController {

    @Autowired
    PersonInterface personInterface;

    @GetMapping("/getPerson")
    public Person getPerson() {
       return personInterface.getPerson();
    }
}
