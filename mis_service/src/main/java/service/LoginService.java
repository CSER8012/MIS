package service;

import entity.Staff;

public interface LoginService {
    public Staff selectByAccount(String account);

    public void resetPassword(String id,String account);
}
