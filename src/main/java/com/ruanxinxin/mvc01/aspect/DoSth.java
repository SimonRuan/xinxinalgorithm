package com.ruanxinxin.mvc01.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DoSth {

    @Pointcut("execution(* com.ruanxinxin.mvc01.service.EmployeeService.getEmps(..))")
    public void empRequest(){}

    @Before("empRequest()")
    public void begin(){
        System.err.println("准备查询了……………………");
    }
}
