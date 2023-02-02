package com.ssafy.ws.step3;

public interface IBookManager {
	void add(Book book);
	void remove(String isbn);
	Book[] getList();
	Book searchByIsbn(String isbn);
	Book[] searchByTitle(String title);
	Magazine[] getMagazines();
	Book[] getBooks();
	int getTotalPrice();
	double getPriceAvg();
	void removeTitles(String title);
	void sortByPriceAsc();
	void sortByIsbnDesc();
	void saveData();
}
