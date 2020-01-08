package com.example.demoserver.controller;

import com.example.demoserver.dao.po.Person;
import com.example.demoserver.service.interfaces.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/Person")
@RestController
public class PersonController {

    @Autowired
    PersonInterface personInterface;

    @GetMapping("/getPerson")
    public List<Person> getPerson() {
       return personInterface.getPerson();
    }
}
