package com.ruanxinxin.controller;

import com.ruanxinxin.bean.Employee;
import com.ruanxinxin.bean.MyPublisher;
import com.ruanxinxin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
//    @Autowired
//    MyPublisher myPublisher;

    @RequestMapping("/emps")
    public String emp(Map<String, Object> map, RedirectAttributes model) {
        List<Employee> employees = employeeService.getEmps();
        map.put("employees", employees);
        return "emps";
    }

    @RequestMapping("/testCache")
    public void testCache1(HttpServletResponse response) throws IOException {
        List<Employee> employees = employeeService.getEmps();

        System.err.println("CACHE CLICK !!!" + employees.size());
        response.getWriter().write("hello world !!!");

    }


    @RequestMapping("/testevent")
    public void testevent(HttpServletResponse response) throws IOException {
        System.out.println("begin");
        new MyPublisher().showPublisher();
    }


}
