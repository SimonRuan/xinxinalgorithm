package mapper.ruanxinxin.mvc01;

import com.ruanxinxin.ServiceStarter;
import com.ruanxinxin.bean.Employee;
import com.ruanxinxin.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest(classes = ServiceStarter.class)
@RunWith(SpringRunner.class)
@ContextConfiguration
public class MyTest {

    @Autowired
    private EmployeeMapper mapper;


    @Test
    public void addEmployeeTest() {
        List<Employee> values= mapper.getAllEmployees();
        List<Employee> employeeList=new ArrayList<>();

        for (int i=0;i<10;i++){
            Employee employee=new Employee();
            employee.setEmail(UUID.randomUUID().toString().substring(0,8)+"qq.com");
            employee.setGender(String.valueOf(i/2));
            employee.setLastName(UUID.randomUUID().toString().substring(0,5));
            employeeList.add(employee);
        }
        mapper.addEmployees(employeeList);
    }


}
