package com.example.demoserver.service.impl;

import com.example.demoserver.dao.interfaces.da1.PersonMapper;
import com.example.demoserver.dao.po.da1.Person;
import com.example.demoserver.dao.po.da1.PersonExample;
import com.example.demoserver.service.interfaces.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PersonImpl implements PersonInterface {

    @Autowired
    PersonMapper personMapper;

    @Override
    public List<Person> getPerson() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria = personExample.createCriteria();
        criteria.andNameEqualTo("xiaohui");
        List<Person> list = personMapper.selectByExample(personExample);
        return list;
    }
}
