package controller;

import entity.Department;
import entity.Staff;
import org.springframework.stereotype.Controller;
import service.DepartmentService;
import service.Impl.DepartmentServiceImpl;
import service.Impl.StaffServiceImpl;
import service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {

    private StaffService staffService = new StaffServiceImpl();
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Staff> list = staffService.selectAll();
        request.getServletContext().setAttribute("list",list);
        response.sendRedirect("http://localhost:8080/mis/staff_list.jsp");
    }

    public void sayHello() {
        System.out.println("Hello World!");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        staffService.delete(id);
        response.sendRedirect("http://localhost:8080/mis/staff/list.do");
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> list = departmentService.getAll();
        request.getServletContext().setAttribute("DLIST",list);
        response.sendRedirect("http://localhost:8080/mis/staff_add.jsp");
    }


    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        Integer did = Integer.parseInt(request.getParameter("did"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String id_number = request.getParameter("id_number");
        String info = request.getParameter("info");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Staff staff = new Staff(account,null,null,did,name,sex,id_number,null,null,bornDate,info);
        staffService.add(staff);
        response.sendRedirect("http://localhost:8080/mis/staff/list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.selectById(id);
        request.getServletContext().setAttribute("OBJ",staff);
        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> list = departmentService.getAll();
        request.getServletContext().setAttribute("DLIST",list);
        response.sendRedirect("http://localhost:8080/mis/staff_edit.jsp");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String account = request.getParameter("account");
        String status = request.getParameter("status");
        Integer did = Integer.parseInt(request.getParameter("did"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String id_number = request.getParameter("id_number");
        String info = request.getParameter("info");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Staff staff =  new Staff(id,account,null,status,did,name,sex,id_number,null,null,bornDate,info);
        staffService.update(staff);
        response.sendRedirect("http://localhost:8080/mis/staff/list.do");

    }

    public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.selectById(id);
        request.getServletContext().setAttribute("OBJ",staff);
        response.sendRedirect("http://localhost:8080/mis/staff_find.jsp");
    }
}
