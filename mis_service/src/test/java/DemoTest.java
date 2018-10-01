import controller.DepartmentController;
import dao.DepartmentDao;
import dao.StaffDao;
import entity.Department;
import entity.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.DepartmentService;
import service.Impl.DepartmentServiceImpl;
import service.Impl.StaffServiceImpl;
import service.StaffService;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring2.xml")
public class DemoTest {

    private  DepartmentService departmentService = new DepartmentServiceImpl();
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");

    //@Autowired
    //DepartmentController obj;

    @Test
    public void demo() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //departmentService.addDepartment(new Department("信息技术部","#2089"));
        //departmentService.removeDepartment(4);
        //departmentService.edit(new Department(7,"科技部","#4018"));
        //Object obj = applicationContext.getBean("departmentController");
        //System.out.println("departmentController = " + obj);
        //Method method = obj.getClass().getMethod("sayHello");
        //method.invoke(obj);
        Object obj = context.getBean("staffController");

        //System.out.println("departmentController = " + obj);
        Method method = obj.getClass().getMethod("sayHello");
        method.invoke(obj);

        List<Department> departments = departmentService.getAll();
        //Object object = applicationContext.getBean("departmentController");
        for(Department department : departments)
            System.out.println(department.toString());
    }

    @Test
    public void demo2() {
        StaffService staffService = new StaffServiceImpl();
        //Staff stf = new Staff(5,"username","123","无",15,"郑同","男","430681196801240058",null,null,null,"科技部部长");
        //staffService.add(stf);
        List<Staff> list = staffService.findStaffByDid(16);
           for(Staff staff : list) {
               System.out.println(staff.toString());
           }

    }
}
