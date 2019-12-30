package com.example.demoserver.controller.impl;

import com.example.demoserver.bean.Person;
import com.example.demoserver.controller.interfaces.PersonInterface;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PersonController implements PersonInterface {

    @Override
    public Person getPerson() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Person person = new Person();
        person.setAge(20);
        person.setMsg(request.getRequestURI());
        person.setName("xiaoming");
        return person;
    }
}
