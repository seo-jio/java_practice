package com.ssafy.hw.step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserManagerImpl implements IUserManager{
    private List<User> userList;
    private static UserManagerImpl um = new UserManagerImpl(); //static 사용 기억!

    private UserManagerImpl(){
        userList = new ArrayList<>();
    }

    public static UserManagerImpl getInstance(){ //static 사용 기억!
        return um;
    }

    public User searchById(String id){
        for(int i=0; i<userList.size(); i++){
            if(userList.get(i).getId().equals(id)){
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        User fu = searchById(user.getId());
        if(fu == null) {
            userList.add(user);
        }else{
            System.out.println("이미 존재하는 유저 입니다.");
        }
    }

    @Override
    public User[] getList() {
        return userList.toArray(new User[0]);
    }

    @Override
    public User[] getUsers() {
        List<User> users = new ArrayList<>();
        for(int i=0; i<userList.size(); i++){
            if(!(userList.get(i) instanceof VipUser)){
                users.add(userList.get(i));
            }
        }
        return users.toArray(new User[0]);
    }

    @Override
    public VipUser[] getVipUsers() {
        List<VipUser> users = new ArrayList<>();
        for(int i=0; i<userList.size(); i++){
            if(userList.get(i) instanceof VipUser){
                users.add((VipUser)userList.get(i));
            }
        }
        return users.toArray(new VipUser[0]);
    }

    @Override
    public User[] searchByName(String name) {
        List<User> users = new ArrayList<>();
        for(int i=0; i<userList.size(); i++){
            if(userList.get(i).getName().equals(name)){
                users.add(userList.get(i));
            }
        }
        return users.toArray(new User[0]);
    }

    @Override
    public double getAgeAvg() {
        int sum = 0;
        for(int i=0; i<userList.size(); i++){
            sum += userList.get(i).getAge();
        }
        return (double)sum / userList.size();
    }
}
