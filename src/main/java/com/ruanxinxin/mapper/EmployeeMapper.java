package com.ruanxinxin.mapper;

import com.ruanxinxin.bean.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

    List<Employee> getAllEmployees();

    Long addEmployees(@Param("empList") List<Employee> empList);
}
