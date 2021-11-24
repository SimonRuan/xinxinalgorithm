package com.ruanxinxin.bean;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ContextRefreshedEvent;

public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
    //ApplicationEventPublisher


}
