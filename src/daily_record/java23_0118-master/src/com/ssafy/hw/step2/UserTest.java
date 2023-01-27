package com.ssafy.hw.step2;

public class UserTest {
	
	public static void main(String[] args) {
		User user1 = new User("id1", "pw1", "steve", "email1", 20);
		User user2 = new User("id2", "pw2", "Tom", "email2", 30);
		User user3 = new VipUser("id3", "pw3", "Kevin", "email3", 40, "Vip", 98);
		
		UserManager um = UserManager.getInstance();
		um.add(user1);
		um.add(user2);
		um.add(user3);
		
		System.out.println("**********************************유저 전체 목록**********************************");
		for(User u : um.getList()) {
			System.out.println(u.toString());
		}
		
		System.out.println("**********************************일반 유저 목록**********************************");
		for(User u : um.getUsers()) {
			System.out.println(u.toString());
		}
		
		System.out.println("**********************************VIP 유저 목록**********************************");
		for(VipUser u : um.getVipUsers()) {
			System.out.println(u.toString());
		}
		
		System.out.println("**********************************유저 이름 포함검색: Tom**********************************");
		for(User u : um.searchByName("Tom")) {
			System.out.println(u.toString());
		}
		System.out.println("유저 나이 평균 : " + um.getAgeAvg());
	}
	
}
