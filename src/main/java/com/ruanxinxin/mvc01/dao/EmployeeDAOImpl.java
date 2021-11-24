package com.ruanxinxin.mvc01.dao;

import com.ruanxinxin.mvc01.bean.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl extends BaseDAOImpl implements EmployeeDAO {
    @Override
    public Employee getEmployee(Integer id){
        Employee employee=(Employee) this.getSqlSessionTemplate().selectOne("EmployeeDAO.getEmployee",id);
        return employee;
    }
}
