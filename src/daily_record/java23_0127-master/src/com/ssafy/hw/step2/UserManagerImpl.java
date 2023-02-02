package com.ssafy.hw.step2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements IUserManager {

	private List<User> userList = new ArrayList<>();

	private final int MAX_SIZE = 100;

	private static UserManagerImpl um = new UserManagerImpl();

	private UserManagerImpl() {
	};

	public static UserManagerImpl getInstance() {
		return um;
	}

	public void add(User user) {
		if (userList.size() < MAX_SIZE) {
			userList.add(user);
		} else {
			System.out.println("유저의 수가 100을 넘었습니다. 등록 불가.");
		}
	}

	public User[] getList() {

		User[] res = new User[userList.size()];

		return this.userList.toArray(res);
	}

	public User[] getUsers() {

		List<User> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				list.add(userList.get(i));
			}
		}

		User[] res = new User[list.size()];

		return list.toArray(res);

	}

	public VipUser[] getVipUsers() {

		List<VipUser> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				list.add((VipUser) userList.get(i));
			}
		}

		VipUser[] res = new VipUser[list.size()];

		return list.toArray(res);

	}

	public User[] searchByName(String name) throws NameNotFoundException {

		List<User> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().contains(name)) {
				list.add(userList.get(i));
			}
		}

		if (list.size() == 0)
			throw new NameNotFoundException(name);

		User[] res = new User[list.size()];

		return list.toArray(res);
	}

	public double getAgeAvg() {

		int sum = 0;

		for (int i = 0; i < userList.size(); i++) {
			sum += userList.get(i).getAge();
		}

		return sum / userList.size();

	}
	
	@Override
	public void saveData() {
		File f = new File("user.dat");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));){
			oos.writeObject(userList);
			System.out.println("유저 리스트를 저장 했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadData() {
		File f = new File("user.dat");
		if(!f.exists()) {
			userList = new ArrayList<>();
			System.out.println("유저 리스트를 로딩 했습니다.");
		}else {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));){
				userList = (List<User>) ois.readObject();
				System.out.println("유저 리스트를 로딩 했습니다.");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
