package com.ruanxinxin.mvc01.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setAge(18);
        person.setName("张三");
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String skjdfls="sjdflksjfdlsk";
}
