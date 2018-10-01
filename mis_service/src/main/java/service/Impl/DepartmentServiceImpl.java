package service.Impl;

import dao.DepartmentDao;
import entity.Department;
import entity.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import service.DepartmentService;
import service.StaffService;

import javax.annotation.Resource;
import java.util.List;


public class DepartmentServiceImpl implements DepartmentService{


    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    DepartmentDao departmentDao = applicationContext.getBean(DepartmentDao.class);

    public void addDepartment(Department department) {
        departmentDao.insert(department);
    }

    public void removeDepartment(Integer id) {
        StaffService staffService = new StaffServiceImpl();
        departmentDao.delete(id);
    }

    public void edit(Department department) {
        StaffService staffService = new StaffServiceImpl();
        departmentDao.update(department);
    }

    public Department getDepartment(Integer id) {
        return departmentDao.selectById(id);
    }

    public List<Department> getAll() {
        if(departmentDao!=null)
            return departmentDao.selectAll();
        return null;
    }
}
