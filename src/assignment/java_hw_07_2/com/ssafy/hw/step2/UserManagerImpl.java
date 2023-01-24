package assignment.java_hw_07_2.com.ssafy.hw.step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserManagerImpl implements IUserManager{
    private static final int MAX_SIZE = 100;
    private User[] userList;
    private int size = 0;
    private static UserManagerImpl um = new UserManagerImpl(); //static 사용 기억!

    private UserManagerImpl(){
        userList = new User[MAX_SIZE];
    }

    public static UserManagerImpl getInstance(){ //static 사용 기억!
        return um;
    }

    public User searchById(String id){
        for(int i=0; i<size; i++){
            if(userList[i].getId().equals(id)){
                return userList[i];
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        User fu = searchById(user.getId());
        if(fu == null) {
            userList[size++] = user;
        }else{
            System.out.println("이미 존재하는 유저 입니다.");
        }
    }

    @Override
    public User[] getList() {
        return Arrays.copyOf(userList, size);
    }

    @Override
    public User[] getUsers() {
        List<User> users = new ArrayList<>();
        for(int i=0; i<size; i++){
            if(!(userList[i] instanceof VipUser)){
                users.add(userList[i]);
            }
        }
        return users.toArray(new User[0]);
    }

    @Override
    public VipUser[] getVipUsers() {
        List<VipUser> users = new ArrayList<>();
        for(int i=0; i<size; i++){
            if(userList[i] instanceof VipUser){
                users.add((VipUser)userList[i]);
            }
        }
        return users.toArray(new VipUser[0]);
    }

    @Override
    public User[] searchByName(String name) {
        List<User> users = new ArrayList<>();
        for(int i=0; i<size; i++){
            if(userList[i].getName().contains(name)){
                users.add(userList[i]);
            }
        }
        return users.toArray(new User[0]);
    }

    @Override
    public double getAgeAvg() {
        int sum = 0;
        for(int i=0; i<size; i++){
            sum += userList[i].getAge();
        }
        return (double)sum / size;
    }
}
