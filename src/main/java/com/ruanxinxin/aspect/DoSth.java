package com.ruanxinxin.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DoSth {

    @Pointcut("execution(* com.ruanxinxin.service.EmployeeService.getEmps(..))")
    public void empRequest(){}

    @Before("empRequest()")
    public void begin(){
        System.err.println("准备查询了……………………");
    }
}
