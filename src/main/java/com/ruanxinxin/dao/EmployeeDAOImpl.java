package com.ruanxinxin.dao;

import com.ruanxinxin.bean.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl extends BaseDAOImpl implements EmployeeDAO {
    @Override
    public Employee getEmployee(Integer id){
        Employee employee=(Employee) this.getSqlSessionTemplate().selectOne("EmployeeDAO.getEmployee",id);
        return employee;
    }
}
