package service.Impl;

import entity.Staff;
import service.LoginService;
import service.StaffService;

public class LoginServiceImpl implements LoginService {
    public Staff selectByAccount(String account) {
        StaffService staffService = new StaffServiceImpl();
        return staffService.selectByAccount(account);
    }

    public void resetPassword(String id, String password) {
        StaffService staffService = new StaffServiceImpl();
        Staff staff = staffService.selectById(Integer.parseInt(id));
        staff.setPassword(password);
        System.out.println();
        staffService.update(staff);
    }
}
