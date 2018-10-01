package service;

import entity.Staff;

import java.util.List;

public interface StaffService {

    public void add(Staff staff);
    public void delete(Integer id);
    public void update(Staff staff);
    public Staff selectById(Integer id);
    public List<Staff> selectAll();
    public List<Staff> findStaffByDid(Integer did);
    public Staff selectByAccount(String account);
}
