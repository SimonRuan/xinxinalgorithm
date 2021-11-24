package com.ruanxinxin.mvc01.mapper;

import com.ruanxinxin.mvc01.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

    List<Employee> getAllEmployees();

    Long addEmployees(@Param("empList") List<Employee> empList);
}
