package service.Impl;

import dao.StaffDao;
import entity.Staff;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StaffService;

import java.util.Date;
import java.util.List;

public class StaffServiceImpl implements StaffService {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    StaffDao staffDao = applicationContext.getBean(StaffDao.class);

    public void add(Staff staff) {
        staff.setWorkTime(new Date());
        staff.setStatus("OK");
        if(staff == null || staff.getPassword() == null)
            staff.setPassword("123456");
        staffDao.insert(staff);
    }

    public void delete(Integer id) {
        staffDao.delete(id);
    }

    public void update(Staff staff) {
        staff.setStatus("OK");
        if(staff == null || staff.getPassword() == null)
            staff.setPassword("123456");
        staffDao.update(staff);
    }

    public Staff selectById(Integer id) {
        return staffDao.selectById(id);
    }

    public List<Staff> selectAll() {
        return staffDao.selectAll();
    }

    public List<Staff> findStaffByDid(Integer did) {
        return staffDao.findStaffByDid(did);
    }

    public Staff selectByAccount(String account) {
        if(staffDao.selectByAccount(account) != null)
            return staffDao.selectByAccount(account);
        return null;
    }

}
