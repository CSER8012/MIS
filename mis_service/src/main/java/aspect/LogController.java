package aspect;
import entity.Log;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import service.Impl.LogServiceImpl;
import service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("logController")
public class LogController {
    private LogService logService = new LogServiceImpl();
    public void operationLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list = logService.getOperationLog();
        request.getServletContext().setAttribute("LIST",list);
        request.getServletContext().setAttribute("TYPE","operation");
        response.sendRedirect("http://localhost:8080/mis/log_list.jsp");
    }

    public void loginLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list = logService.getLoginLog();
        request.getServletContext().setAttribute("LIST",list);
        request.getServletContext().setAttribute("TYPE","login");
        response.sendRedirect("http://localhost:8080/mis/log_list.jsp");
    }

    public void systemLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list = logService.getSystemLog();
        request.getServletContext().setAttribute("LIST",list);
        request.getServletContext().setAttribute("TYPE","system");
        response.sendRedirect("http://localhost:8080/mis/log_list.jsp");
    }
}
