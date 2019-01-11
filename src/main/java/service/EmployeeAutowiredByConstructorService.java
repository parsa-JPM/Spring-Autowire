package service;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeAutowiredByConstructorService {
    private Employee employee;

    //Autowired annotation on Constructor is equivalent to autowire="constructor"
    //When this bean will be initialized by Spring framework,
    // bean with name as “employee” will be used for autowiring
    @Autowired(required = false)
    public EmployeeAutowiredByConstructorService(@Qualifier("employee2") Employee emp) {
        this.employee = emp;
    }

    public Employee getEmployee() {
        return this.employee;
    }
}
