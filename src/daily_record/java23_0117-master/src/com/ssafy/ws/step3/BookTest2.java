package com.ssafy.ws.step3;
import java.io.*;
public class BookTest2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BookManager bm = BookManager.getInstance();
		bm.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bm.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bm.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		
		Book[] books = bm.getList();
		System.out.println("*****************************도서목록*****************************");
		for(Book b : books) {
			System.out.println(b);
		}
		
		System.out.println("**************************도서조회:21424**************************");
		String isbn = "21424";
		Book fBook = bm.searchByIsbn(isbn);
		System.out.println(fBook);
		
		System.out.println("**************************도서삭제:21424**************************");
		bm.remove(isbn);
		books = bm.getList();
		System.out.println("*****************************도서목록*****************************");
		for(Book b : books) {
			System.out.println(b);
		}
	}
}
