package com.ruanxinxin.bean;

import com.ruanxinxin.service.EmployeeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class MyPublisher implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Autowired
    EmployeeService employeeService;

    public void showPublisher() {
        MyEvent myEvent = new MyEvent(this);
        applicationContext.publishEvent(myEvent);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
