package aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import entity.Log;
import entity.Staff;
import service.Impl.LogServiceImpl;
import service.LogService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
public class LogAdvice {
    private LogService logService = new LogServiceImpl();

    @AfterReturning("execution(* controller.*.*(..)) && !execution(* controller.selfController.*(..)) && !execution(* controller.*.to*(..))")
    public void operationLog(JoinPoint joinPoint){
        System.out.println("after aspecj");
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        Staff staff =(Staff)obj;
        log.setOperator(staff.getAccount());
        log.setResult("Success");
        logService.addOperationLog(log);
    }
    @AfterThrowing(throwing ="e",pointcut ="execution(* controller.*.*(..)) && !execution(* controller.selfController.*(..))")
    public void systemLog(JoinPoint joinPoint,Throwable e){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff =(Staff)obj;
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);
    }
    @After("execution(* controller.selfController.login(..))")
    private void login(JoinPoint joinPoint){
        System.out.println("after aspecj");
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        if(obj==null){
            log.setOperator(request.getParameter("account"));
            log.setResult("Failure");
        }else {
            Staff staff = (Staff) obj;
            log.setOperator(staff.getAccount());
            log.setResult("Success");
        }
        logService.addLoginLog(log);
    }

    @Before("execution(* controller.selfController.logout(..))")
    private void logout(JoinPoint joinPoint){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        Staff staff = (Staff) obj;
        log.setOperator(staff.getAccount());
        log.setResult("Success");
        logService.addLoginLog(log);
    }
}

