package service;

import entity.Log;

import java.util.List;

public interface LogService {
    void addSystemLog(Log log);
    void addOperationLog(Log log);
    void addLoginLog(Log log);

    List<Log> getSystemLog();
    List<Log> getOperationLog();
    List<Log> getLoginLog();
}
