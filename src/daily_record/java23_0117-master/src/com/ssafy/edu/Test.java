package com.ssafy.edu;

public class Test {

	public static void main(String[] args) {
		Lotto lot = new Lotto();
		Lotto lot2 = new Lotto();
		System.out.println(lot.hashCode());
		System.out.println(lot.toString());
		System.out.println(lot.getClass());
		System.out.println(lot.equals(lot2));
		System.out.println(Integer.toHexString(lot.hashCode()));
	}

}
