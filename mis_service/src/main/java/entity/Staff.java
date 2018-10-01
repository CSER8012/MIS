package entity;
import service.Impl.DepartmentServiceImpl;

import java.util.Date;
public class Staff {
    private Integer id;
    private String account;
    private String password;
    private String status;
    private Integer did;
    private String name;
    private String sex;
    private String idNumber;
    private Date workTime;
    private Date leaveTime;
    private Date bornDate;
    private String info;
    private Department department;


    public Staff() {

    }

    public Staff(Integer id, String account, String password, String status, Integer did, String name, String sex, String idNumber, Date workTime, Date leaveTime, Date bornDate, String info) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.status = status;
        this.did = did;
        this.name = name;
        this.sex = sex;
        this.idNumber = idNumber;
        this.workTime = workTime;
        this.leaveTime = leaveTime;
        this.bornDate = bornDate;
        this.info = info;
        setDepartment(new DepartmentServiceImpl().getDepartment(did));
    }

    public Staff(String account, String password, String status, Integer did, String name, String sex, String idNumber, Date workTime, Date leaveTime, Date bornDate, String info) {
        this.account = account;
        this.password = password;
        this.status = status;
        this.did = did;
        this.name = name;
        this.sex = sex;
        this.idNumber = idNumber;
        this.workTime = workTime;
        this.leaveTime = leaveTime;
        this.bornDate = bornDate;
        this.info = info;
        setDepartment(new DepartmentServiceImpl().getDepartment(did));
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", did=" + did +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", workTime=" + workTime +
                ", leaveTime=" + leaveTime +
                ", bornDate=" + bornDate +
                ", info='" + info + '\'' +
                ", department=" + department +
                '}';
    }


}
