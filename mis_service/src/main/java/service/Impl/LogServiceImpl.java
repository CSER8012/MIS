package service.Impl;

import dao.LogDao;
import entity.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.LogService;

import java.util.Date;
import java.util.List;

public class LogServiceImpl implements LogService {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    LogDao logDao = applicationContext.getBean(LogDao.class);

    public void addSystemLog(Log log) {
        log.setOprTime(new Date());
        log.setType("system");
        logDao.insert(log);
    }

    public void addOperationLog(Log log) {
        log.setOprTime(new Date());
        log.setType("operation");
        logDao.insert(log);
    }

    public void addLoginLog(Log log) {
        log.setOprTime(new Date());
        log.setType("login");
        logDao.insert(log);
    }

    public List<Log> getSystemLog() {
       return logDao.selectByType("system");
    }

    public List<Log> getOperationLog() {
        return logDao.selectByType("operation");
    }

    public List<Log> getLoginLog() {
        return logDao.selectByType("login");
    }
}
