package com.ssafy.ws.step3;

public class ISBNNotFoundException extends Exception{
	private String isbn;
	
	public ISBNNotFoundException() {}
	
	public ISBNNotFoundException(String message) {
		super(message);
	}
	
	public String getIsbn() {
		return this.isbn;
	}
}
