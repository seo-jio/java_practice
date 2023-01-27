package com.ssafy.ws.step3;


import java.util.ArrayList;
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
	private Book[] books; //aggregation(집합), BookManager <>------> Book
	
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
	
	public Book[] searchByTitle(String title) {
		ArrayList<Book> fBooks = new ArrayList<>();
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) {
				fBooks.add(books[i]);
			}
		}
		return fBooks.toArray(new Book[fBooks.size()]);
	}
	
	public Magazine[] getMagazines() {
		ArrayList<Magazine> fMag = new ArrayList<>();
		for(int i=0; i<size; i++) {
			if(books[i] instanceof Magazine) {
				fMag.add((Magazine) books[i]);
			}
		}
		return fMag.toArray(new Magazine[fMag.size()]);
	}
	
	public Book[] getBooks() {
		ArrayList<Book> fBook = new ArrayList<>();
		for(int i=0; i<size; i++) {
			if(!(books[i] instanceof Magazine)) {
				fBook.add(books[i]);
			}
		}
		return fBook.toArray(new Book[fBook.size()]);
	}
	
	public int getTotalPrice() {
		int sum = 0;
		for(int i=0; i<size; i++) {
			sum += books[i].getPrice();
		}
		return sum;
	}
	
	public double getPriceAvg() {
		int sum = getTotalPrice();
		return sum / (double) size;
	}
	
	public int getSize() {
		return size;
	}
	
}
