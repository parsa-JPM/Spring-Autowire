package service;

import model.Employee;

public class EmployeeService {

    //    @Autowired
//    @Qualifier("employee1")
    private Employee employee2;


    // constructor is used for autowire by constructor
    public EmployeeService(Employee emp) {
        System.out.println("Autowiring by constructor used");
        this.employee2 = emp;
    }

    // default constructor to avoid BeanInstantiationException for autowire
    // byName or byType
    // When we use spring autowire byName or byType, default constructor is used.
    // That’s why we have explicitly defined the default constructor for the EmployeeService bean.
    public EmployeeService() {
        System.out.println("Default Constructor used");
    }

    // used for autowire byName and byType
    public void setEmployee2(Employee emp) {
        System.out.println("use setter to init");
        this.employee2 = emp;
    }

    public Employee getEmployee2() {
        return this.employee2;
    }
}
