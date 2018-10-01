package service;

import entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public interface DepartmentService {
    void addDepartment(Department department);
    void removeDepartment(Integer id);
    void edit(Department department);
    Department getDepartment(Integer id);
    List<Department> getAll();
}
