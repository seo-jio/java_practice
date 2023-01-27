package com.ssafy.hw.step2;

import java.util.ArrayList;
import java.util.Arrays;

public class UserManager {
	private static UserManager um = new UserManager();
	private final static int MAX_SIZE = 100;
	private int size = 0;
	private User[] userList;
	
	private UserManager() {
		userList = new User[MAX_SIZE];
	}
	
	public static UserManager getInstance() {
		return um;
	}
	
	
	public void add(User user) {
		int flag = 0;
		for(int i=0; i<size; i++) {
			if(userList[i].getId().equals(user.getId())) {
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			userList[size++] = user;
		}
	}
	
	public User[] getList() {
		return Arrays.copyOf(userList, size);
	}
	
	public User[] getUsers() {
		ArrayList<User> users = new ArrayList<>();
		for(int i=0; i<size; i++) {
			if(!(userList[i] instanceof VipUser)){
				users.add(userList[i]);
			}
		}
		return users.toArray(new User[users.size()]);
	}
	
	
	public VipUser[] getVipUsers() {
		ArrayList<VipUser> vUsers = new ArrayList<>();
		for(int i=0; i<size; i++) {
			if(userList[i] instanceof VipUser) {
				vUsers.add((VipUser)userList[i]);
			}
		}
		return vUsers.toArray(new VipUser[vUsers.size()]);
	}
	
	public User[] searchByName(String name) {
		ArrayList<User> users = new ArrayList<>();
		for(int i=0; i<size; i++) {
			if(userList[i].getName().equals(name)) {
				users.add(userList[i]);
			}
		}
		return users.toArray(new User[users.size()]);
	}
	
	public double getAgeAvg() {
		int sum = 0;
		for(int i=0; i<size; i++) {
			sum += userList[i].getAge();
		}
		return sum / (double) size;
	}
}
