package com.ssafy.ws.step3;

import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class BookTest2 {
	
	static BookManager bm = BookManager.getInstance();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("안녕하세요...SSAFY Book입니다.");
		init();
		
	}
	
	public static void init() {
		while(true) {
			System.out.println("원하는 번호를 입력하세요 >> ");
			System.out.println("1. 전체  도서목록 보기");
			System.out.println("2. 새로운 도서 추가");
			System.out.println("3. 도서 찾기");
			System.out.println("4. 프로그램 종료");
			
			int n = Integer.parseInt(sc.nextLine());
			
			switch(n) {
			case 1:
				getList();
				break;
			case 2:
				add();
				break;
			case 4:
				end();
				break;
				
			}
		}
	}
	
	public static void getList() {
		Book[] books = bm.getList();
		System.out.println("**********************************도서 전체 목록**********************************");
		print(books);
	}
	
	public static void print(Book[] books) {
		for(Book b : books) {
			System.out.println(b.toString());
		}
	}
	
	public static void end() {
		System.out.println("Good bye~~~");
		System.exit(0);
	}
	
	public static void add() {
		System.out.println("추가하려는 종류를 선택하세요 >> ");
		System.out.println("1. 일반 도서 추가");
		System.out.println("2. 잡지 추가");
		
		int n = Integer.parseInt(sc.nextLine());
		if(n == 1) {
			System.out.println("isbn을 입력하세요 >> ");
			String isbn = sc.nextLine();
			
			System.out.println("title을 입력하세요 >> ");
			String title = sc.nextLine();
			
			System.out.println("author을 입력하세요 >> ");
			String author = sc.nextLine();
			
			System.out.println("publisher을 입력하세요 >> ");
			String publisher = sc.nextLine();
			
			System.out.println("price을 입력하세요 >> ");
			int price = Integer.parseInt(sc.nextLine());
			
			System.out.println("desc을 입력하세요 >> ");
			String desc = sc.nextLine();
			
			bm.add(new Book(isbn, title, author, publisher, price, desc));
			
		}else {
			System.out.println("isbn을 입력하세요 >> ");
			String isbn = sc.nextLine();
			
			System.out.println("title을 입력하세요 >> ");
			String title = sc.nextLine();
			
			System.out.println("author을 입력하세요 >> ");
			String author = sc.nextLine();
			
			System.out.println("publisher을 입력하세요 >> ");
			String publisher = sc.nextLine();
			
			System.out.println("price을 입력하세요 >> ");
			int price = Integer.parseInt(sc.nextLine());
			
			System.out.println("desc을 입력하세요 >> ");
			String desc = sc.nextLine();
			
			System.out.println("year을 입력하세요 >> ");
			int year = Integer.parseInt(sc.nextLine());
			
			System.out.println("month을 입력하세요 >> ");
			int month = Integer.parseInt(sc.nextLine());
			
			bm.add(new Magazine(isbn, title, author, publisher, price, desc, year, month));
		}
	}
	
}
