import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.EmployeeAutowiredByConstructorService;
import service.EmployeeAutowiredByTypeService;
import service.EmployeeService;

public class Client {
    private static ClassPathXmlApplicationContext ctx;

    public static void main(String[] args) {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        test();
        anntoationBasedTest();
        ctx.close();
    }

    private static void test(){

        EmployeeService serviceByName = ctx.getBean("employeeServiceByName", EmployeeService.class);

        System.out.println("Autowiring byName. Employee Name="+serviceByName.getEmployee2().getName());

        EmployeeService serviceByType = ctx.getBean("employeeServiceByType", EmployeeService.class);

        System.out.println("Autowiring byType. Employee Name="+serviceByType.getEmployee2().getName());

        EmployeeService serviceByConstructor = ctx.getBean("employeeServiceConstructor", EmployeeService.class);

        System.out.println("Autowiring by Constructor. Employee Name="+serviceByConstructor.getEmployee2().getName());

        //printing hashcode to confirm all the objects are of different type
//        System.out.println(serviceByName.hashCode()+"::"+serviceByType.hashCode()+"::"+serviceByConstructor.hashCode());

    }

    private static void anntoationBasedTest(){
        //Testing @Autowired annotations
        EmployeeAutowiredByTypeService autowiredByTypeService = ctx.getBean("employeeAutowiredByTypeService", EmployeeAutowiredByTypeService.class);

        System.out.println("@Autowired byType. Employee Name="+autowiredByTypeService.getEmployee().getName());

        EmployeeAutowiredByConstructorService autowiredByConstructorService = ctx.getBean("employeeAutowiredByConstructorService", EmployeeAutowiredByConstructorService.class);

        System.out.println("@Autowired by Constructor. Employee Name="+autowiredByConstructorService.getEmployee().getName());
    }
}
