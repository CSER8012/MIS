package controller;

import entity.Staff;
import org.springframework.stereotype.Controller;
import service.Impl.LoginServiceImpl;
import service.Impl.StaffServiceImpl;
import service.LoginService;
import service.StaffService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("selfController")
public class selfController {
    private LoginService loginService = new LoginServiceImpl();
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        Staff staff = loginService.selectByAccount(account);

        if(staff == null || !staff.getPassword().equals(password)) {
            response.sendRedirect("http://localhost:8080/mis/login.jsp?valid=0");
            return;
        }

        request.getSession().setAttribute("user",staff);

        response.sendRedirect("http://localhost:8080/mis/index.jsp");
    }

    public void resetPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String initial = request.getParameter("initial");
        Staff staff = new StaffServiceImpl().selectById(Integer.parseInt(id));
        if(!staff.getPassword().equals(initial)) {
            response.sendRedirect("http://localhost:8080/mis/resetPassword.jsp?flag=0");
            return;
        }

        String password = request.getParameter("password");

        loginService.resetPassword(id,password);

        response.getWriter().print("<script>parent.location.href=\"http://localhost:8080/mis/logout.do\"</script>");
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect("http://localhost:8080/mis/login.jsp");
    }
}
