package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.Arrays;

public class BookManagerImpl implements IBookManager{
	
	private static BookManagerImpl bm = new BookManagerImpl();
	
	private final static int MAX_SIZE = 100;
	private Book[] books;
	private int size;

	private BookManagerImpl() {
		books = new Book[MAX_SIZE];
	}
	
	public static BookManagerImpl getInstance() {
		return bm;
	}
	
	@Override
	public void add(Book book) {
		if(searchByIsbn(book.getIsbn()) == null) {
			books[size] = book;
			size++;
		}
	}
	
	@Override
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
	
	@Override
	public Book[] getList() {
//		return books; //이러면 안된다!!!!
		return Arrays.copyOf(books,  size);
	}
	
	@Override
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
	
	@Override
	public Book[] searchByTitle(String title) {
		ArrayList<Book> fBooks = new ArrayList<>();
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) {
				fBooks.add(books[i]);
			}
		}
		return fBooks.toArray(new Book[fBooks.size()]);
	}
	
	@Override
	public Magazine[] getMagazines() {
		ArrayList<Magazine> fMag = new ArrayList<>();
		for(int i=0; i<size; i++) {
			if(books[i] instanceof Magazine) {
				fMag.add((Magazine) books[i]);
			}
		}
		return fMag.toArray(new Magazine[fMag.size()]);
	}
	
	@Override
	public Book[] getBooks() {
		ArrayList<Book> fBook = new ArrayList<>();
		for(int i=0; i<size; i++) {
			if(!(books[i] instanceof Magazine)) {
				fBook.add(books[i]);
			}
		}
		return fBook.toArray(new Book[fBook.size()]);
	}
	
	@Override
	public int getTotalPrice() {
		int sum = 0;
		for(int i=0; i<size; i++) {
			sum += books[i].getPrice();
		}
		return sum;
	}
	
	@Override
	public double getPriceAvg() {
		int sum = getTotalPrice();
		return sum / (double) size;
	}
	
	public int getSize() {
		return size;
	}

	@Override
	public void removeTitles(String title) {
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) {
				books[i] = books[size-1];
				size--;
			}
		}
	}
	
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException{
		Book b = searchByIsbn(isbn);
		if(b == null) {
			throw new ISBNNotFoundException(isbn + "에 해당하는 책이 없습니다.");
		}
		if(b.getQuantity() < quantity) {
			throw new QuantityException("수량이 부족합니다.");
		}
		b.setQuantity(b.getQuantity() - quantity);
		if(b.getQuantity() == 0){
			remove(isbn);
			System.out.println(isbn + " 도서가 솔드아웃 입니다.");
		}else {
			System.out.println(b.toString());
		}
	}
	
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		Book b = searchByIsbn(isbn);
		if(b == null) {
			throw new ISBNNotFoundException(isbn + "에 해당하는 책이 없습니다.");
		}
		b.setQuantity(b.getQuantity() + quantity);
		System.out.println(b.toString());
	}
}
