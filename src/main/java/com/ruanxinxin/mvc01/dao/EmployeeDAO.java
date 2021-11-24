package com.ruanxinxin.mvc01.dao;

import com.ruanxinxin.mvc01.bean.Employee;
import org.springframework.stereotype.Repository;

//使用注解标记DAO层
@Repository
public interface EmployeeDAO {
     Employee getEmployee(Integer id);
}
