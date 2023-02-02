package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookManagerImpl implements IBookManager{
	
	private static BookManagerImpl bm = new BookManagerImpl();
	private List<Book> books;

	private BookManagerImpl() {
		books = new ArrayList<>();
	}
	
	public static BookManagerImpl getInstance() {
		return bm;
	}
	
	@Override
	public void add(Book book) {
		if(searchByIsbn(book.getIsbn()) == null) {
			books.add(book);
		}
	}
	
	@Override
	public void remove(String isbn) {
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}
	}
	
	@Override
	public Book[] getList() {
		return books.toArray(new Book[0]);
	}
	
	@Override
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).equals(new Book(isbn))) {
				return books.get(i);
			}
		}
		return null;
	}
	
	@Override
	public Book[] searchByTitle(String title) {
		ArrayList<Book> fBooks = new ArrayList<>();
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getTitle().contains(title)) {
				fBooks.add(books.get(i));
			}
		}
		return fBooks.toArray(new Book[0]);
	}
	
	@Override
	public Magazine[] getMagazines() {
		ArrayList<Magazine> fMag = new ArrayList<>();
		for(int i=0; i<books.size(); i++) {
			if(books.get(i) instanceof Magazine) {
				fMag.add((Magazine) books.get(i));
			}
		}
		return fMag.toArray(new Magazine[fMag.size()]);
	}
	
	@Override
	public Book[] getBooks() {
		ArrayList<Book> fBook = new ArrayList<>();
		for(int i=0; i<books.size(); i++) {
			if(!(books.get(i) instanceof Magazine)) {
				fBook.add(books.get(i));
			}
		}
		return fBook.toArray(new Book[fBook.size()]);
	}
	
	@Override
	public int getTotalPrice() {
		int sum = 0;
		for(int i=0; i<books.size(); i++) {
			sum += books.get(i).getPrice();
		}
		return sum;
	}
	
	@Override
	public double getPriceAvg() {
		int sum = getTotalPrice();
		return sum / (double) books.size();
	}
	
	public int getSize() {
		return books.size();
	}

	@Override
	public void removeTitles(String title) {
		for(int i=books.size()-1; i>-1; i--) {
			if(books.get(i).getTitle().contains(title)) {
				books.remove(i);
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

	@Override
	public void sortByPriceAsc() {
		books.sort((o1, o2) -> (Integer.compare(o1.getPrice(), o2.getPrice())));
	}

	@Override
	public void sortByIsbnDesc() {
		books.sort((o1, o2) -> (-o1.getIsbn().compareTo(o2.getIsbn())));
	}
}
