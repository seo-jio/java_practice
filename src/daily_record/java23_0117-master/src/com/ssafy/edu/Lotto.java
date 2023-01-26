package com.ssafy.edu;

import java.util.Arrays;

public class Lotto { //extends Object
	private int[] lots;
	private int n;
	
	public Lotto() {
		this(6);
	}
	
	public Lotto(int n) {
//		System.out.println("hello"); //에러 발생
		super(); //Object의 여러 생성자 중 default 생성자를 호출, 가장 첫 줄에 위치해야한다, 자동으로 생성되므로 꼭 안써도 됨
		this.n = n; //지역 변수와 멤버 변수 이름이 같으면 this를 붙여줌, static 변수는 this 사용 불가
		lots = new int[n]; // 배열 default 초기화
	}
	
	public void print() {
		for(int i=0; i<n; i++) { //n은 멤버 변수, this가 자동으로 붙음
			System.out.print(lots[i] + " ");
		}
		System.out.println();
	}
	
	public void make() {
		lots = new int[n];
		int count = 0;
		while(count != n) {
			int temp = (int)(Math.random()*45 +1);
			if(!isSame(temp)) {
				lots[count] = temp;
				count++;
			}
		}
		Arrays.sort(lots);
	}

	private boolean isSame(int temp) {
		for(int i=0; i<lots.length; i++) {
			if(lots[i]==temp) {
				return true;
			}
		}
		return false;
	}
}
