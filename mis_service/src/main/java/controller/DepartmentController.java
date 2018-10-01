package controller;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import entity.Department;
import entity.Staff;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import service.DepartmentService;
import service.Impl.DepartmentServiceImpl;
import service.Impl.StaffServiceImpl;
import service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {

    private DepartmentService departmentService = new DepartmentServiceImpl();
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flag = request.getParameter("flag");
        List<Department> list = departmentService.getAll() ;
        request.getServletContext().setAttribute("Deplist",list);

        if(flag == null || flag.equals(""))
            response.sendRedirect("http://localhost:8080/mis/department_list.jsp");

        else
            response.sendRedirect("http://localhost:8080/mis/department_list.jsp?flag="+flag);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        StaffService staffService = new StaffServiceImpl();
        List<Staff> staffList = staffService.findStaffByDid(id);
        if(staffList.size() != 0) {
            response.sendRedirect("http://localhost:8080/mis/department/list.do?flag=0");
            return;
        }
        departmentService.removeDepartment(id);
        response.sendRedirect("http://localhost:8080/mis/department/list.do");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Department department = new Department(name,address);
        departmentService.addDepartment(department);
        response.sendRedirect("http://localhost:8080/mis/department/list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        StaffService staffService = new StaffServiceImpl();
        List<Staff> staffList = staffService.findStaffByDid(id);
        if(staffList.size() != 0) {
            response.sendRedirect("http://localhost:8080/mis/department/list.do?flag=1");
            return;
        }
        Department department = departmentService.getDepartment(id);
        request.getServletContext().setAttribute("OBJedit",department);
        response.sendRedirect("http://localhost:8080/mis/department_edit.jsp");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Department department = new Department(id,name,address);
        departmentService.edit(department);
        response.sendRedirect("http://localhost:8080/mis/department/list.do");

    }

    public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Department department = departmentService.getDepartment(id);
        request.getServletContext().setAttribute("OBJfind",department);
        response.sendRedirect("http://localhost:8080/mis/department_find.jsp");
    }
}
