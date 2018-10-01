package global;

import controller.DepartmentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class RequestDispatcherServlet extends HttpServlet {

    private ApplicationContext applicationContext;

    @Override
    public void init() throws ServletException {
        super.init();
        applicationContext = new ClassPathXmlApplicationContext("springBean.xml");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        String beanName = null;
        String methodName = null;
        path = path.substring(1,path.length());
        int index = path.indexOf("/");
        System.out.println("index = " + index);
        if(index == -1) {
            beanName = "selfController";
            methodName = path.substring(0,path.indexOf(".do"));

        }

        else {
            beanName = path.substring(0,index) + "Controller";
            methodName = path.substring(index+1,path.indexOf(".do"));
        }

        Object object = applicationContext.getBean(beanName);
        try {
            Method method = object.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(object,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
