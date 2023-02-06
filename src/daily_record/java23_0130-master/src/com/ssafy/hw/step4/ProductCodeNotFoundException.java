package com.ssafy.hw.step4;

/**
 * 해당 상품코드를 조회하지 못했을 때 예외클래스
 */
public class ProductCodeNotFoundException extends Exception{
	/** 존재하지 않는 상품 코드*/
	private String pCode;
	
	public ProductCodeNotFoundException(String pCode) {
		super(pCode+"해당 상품은 존재하지 않습니다.");
		this.pCode = pCode;
	}
	

}
