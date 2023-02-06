package com.ssafy.hw.step4;

/**
 * 검색한 이름을 포함하는 상품이 존재하지 않는 예외정보를 나타내는 클래스
 */
public class NameNotFoundException extends Exception {
	public NameNotFoundException(String name) {
		super(name + "을 포함하는 상품을 존재하지 않습니다.");
	}

}
