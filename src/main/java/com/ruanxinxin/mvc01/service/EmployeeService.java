package com.ruanxinxin.mvc01.service;

import com.ruanxinxin.mvc01.bean.Employee;
import com.ruanxinxin.mvc01.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sun.util.resources.cldr.ar.TimeZoneNames_ar;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;


    @CachePut("empsCache")
    public List<Employee> getEmps(){
        return employeeMapper.getAllEmployees();

    }

//    @Scheduled(fixedRate = 3000)
//    public void scheduleTest(){
//        System.err.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.mmm").format(new Date()));
//    }

    @Async
    public void asyncMethod1(Integer i){
        System.out.println("1方法"+i);
    }

    @Async
    public void asyncMethod2(Integer i){
        System.err.println("2方法"+(i+1));
    }

    public void printStr(String str){
        System.err.println("hello "+str);
    }

    public void printNoStr(){
        System.err.println("hello 没有参数");
    }

}
