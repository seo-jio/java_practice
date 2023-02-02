package com.ssafy.ws.step3;

import java.io.Serializable;

public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4765328221175202885L;
	
	protected String isbn;
	protected String title;
	protected String author;
	protected String publisher;
	protected int    price;
	protected String desc;
	protected int quantity;
	
	public Book() {}
	
	
	public Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.quantity = quantity;
	}
	
	public Book(String isbn) {
		this.isbn = isbn;
	}
	

	@Override
	public int hashCode() { //isbn이 같으면 같은 hashCode를 지니도록 override
		final int prime = 31; //원래 주소는 짝수인데 홀수를 줘서 없는 주소를 준다 => 주소 충돌을 막기 위해
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode()); //isbn을 활용해서 존재하지 않는 hash code 생성
		return result;
	}


	@Override   //isbn이 같으면 equals()가 true를 return하도록 override
	public boolean equals(Object obj) { //override할 때 파라미터를 변경할 수 없으므로 Object를 받음
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false; //직접 구현할 때는 이 위에 부분은 날려도 됨
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", desc=" + desc + ", quantity=" + quantity + "]";
	}


	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
