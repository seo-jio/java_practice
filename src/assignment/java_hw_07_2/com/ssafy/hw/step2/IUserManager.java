package assignment.java_hw_07_2.com.ssafy.hw.step2;

public interface IUserManager {
    void add(User user);
    User[] getList();
    User[] getUsers();
    VipUser[] getVipUsers();
    User[] searchByName(String name);
    double getAgeAvg();
}
