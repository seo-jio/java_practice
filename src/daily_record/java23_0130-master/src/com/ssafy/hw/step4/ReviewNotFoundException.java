package com.ssafy.hw.step4;

/**
 * 해당 상품의 리뷰가 존재하지 않는 예외정보를 나타내는 클래스
 */
public class ReviewNotFoundException extends Exception {
	public ReviewNotFoundException(String pCode) {
		super(pCode + "상품의 리뷰는 존재하지 않습니다.");
	}

}
