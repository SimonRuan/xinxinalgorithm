package com.ruanxinxin.mvc01.bean;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        Class eventClass = applicationEvent.getClass();
        System.out.println("事件本身类型： " + eventClass);

        Class clazz = applicationEvent.getSource().getClass();
        System.out.println("事件source类型： " + clazz);

    }

    public MyListener() {
        String s = "";
        System.out.println(s);
    }

}
