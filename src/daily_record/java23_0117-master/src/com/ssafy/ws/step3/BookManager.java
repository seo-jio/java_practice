package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManager {
	//싱글톤 패턴, 객체를 한번만 생성하고 이를 여러 곳에서 사용 하는 것
	private static BookManager bookManager = new BookManager();
	private BookManager() {
		books = new Book[MAX_SIZE]; //생성자 호출 시 생성 됨, 참조 타입은 초기화가 안되기 때문에 아직 생성되지 않음
	}
	public static BookManager getInstance() {
		return bookManager;
	}
	
	private final static int MAX_SIZE=100;
	private int size;
	private Book[] books; //aggregation(다대일)
	
	public void add(Book book) {
		if(searchByIsbn(book.getIsbn()) == null) {
			books[size] = book;
			size++;
		}
	}
	
	public void remove(String isbn) {
		int idx = -1;
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				idx = i;
				break;
			}
		}
		if(idx != -1) {
			//스왑
			Book temp = books[idx];
			books[idx] = books[size-1];
			books[size-1] = temp;
			//제거 및 size 감소
			books[size-1] = null;
			size--;
		}
	}
	
	public Book[] getList() {
//		return books; //이러면 안된다!!!!
		return Arrays.copyOf(books,  size);
	}
	
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
}
