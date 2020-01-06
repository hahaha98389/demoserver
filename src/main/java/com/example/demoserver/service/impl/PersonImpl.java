package com.example.demoserver.service.impl;

import com.example.demoserver.bean.Person;
import com.example.demoserver.service.interfaces.PersonInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class PersonImpl implements PersonInterface {

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
