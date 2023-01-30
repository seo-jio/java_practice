package com.ssafy.ws.step4;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductManager {
	private static final int MAX_PRODUCT_SIZE = 100;
	private static final int MAX_REVIEW_SIZE = 100;
	private Product[] products;
	private Review[] reviews;
	private int pCount = 0;
	private int rCount = 0;
	
	private static ProductManager pm = new ProductManager(); 
	
	private ProductManager() {
		products = new Product[MAX_PRODUCT_SIZE];
		reviews = new Review[MAX_REVIEW_SIZE]; 
	}
	
	public static ProductManager getInstance() {
		return pm;
	}
	
	public boolean addProduct(Product product) {
		Product fp = searchByCode(product.getpCode());
		if(fp == null) {
			products[pCount++] = product;
			return true;
		}
		return false;
	}
	
	public Product searchByCode(String pCode) {
		for(int i=0; i<pCount; i++) {
			if(products[i].getpCode().equals(pCode)) {
				return products[i];
			}
		}
		return null;
	}
	
	public boolean updateProduct(Product product) {
		Product fp = searchByCode(product.getpCode());
		if(fp != null) {
			int idx = -1;
			for(int i=0; i<pCount; i++) {
				if(products[i].getpCode().equals(product.getpCode())) {
					idx = i;
					break;
				}
			}
			products[idx] = product;
			return true;
		}
		return false;
	}
	
	public boolean removeProduct(String pCode) {
		Product fp = searchByCode(pCode);
		if(fp != null) {
			int idx = -1;
			for(int i=0; i<pCount; i++) {
				if(products[i].getpCode().equals(pCode)) {
					idx = i;
					break;
				}
			}
			products[idx] = products[pCount];
			pCount--;
			return true;
		}
		return false;
	}
	
	public Product[] getProductList() {
		return Arrays.copyOf(products, pCount);
	}
	
	public Review searchByReviewId(int reviewId) {
		for(int i=0; i < rCount; i++) {
			if(reviews[i].getReviewId() == reviewId) {
				return reviews[i];
			}
		}
		return null;
	}
	
	public boolean addReview(Review review) {
		Review fr = searchByReviewId(review.getReviewId());
		if(fr == null) {
			reviews[rCount++] = review;
			return true;
		}
		return false;
	}
	
	public boolean removeReview(int reviewId) {
		Review fr = searchByReviewId(reviewId);
		if(fr != null) {
			int idx = -1;
			for(int i=0; i<rCount; i++) {
				if(reviews[i].getReviewId() == reviewId) {
					idx = i;
					break;
				}
			}
			reviews[idx] = reviews[rCount];
			rCount--;
			return true;
		}
		return false;
	}
	
	public Review[] getProductReview(String pCode) {
		ArrayList<Review> rAl = new ArrayList<>();
		Product fp = searchByCode(pCode);
		if(fp != null) {
			for(int i=0; i<rCount; i++) {
				if(reviews[i].getpCode() == pCode) {
					rAl.add(reviews[i]);
				}
			}
			return rAl.toArray(new Review[rAl.size()]);
		}
		return null;
	}
	
	public Product[] searchByName(String name) {
		ArrayList<Product> pAl = new ArrayList<>();
		for(int i=0; i<pCount; i++) {
			if(products[i].getpName().contains(name)) {
				pAl.add(products[i]);
			}
		}
		return pAl.toArray(new Product[pAl.size()]);
	}
	
	public long getTotalPrice() {
		long sum =0L;
		for(int i=0; i<pCount; i++) {
			sum += (long) (products[i].getPrice() * products[i].getQuantity());
		}
		return sum;
	}
	
	public Product[] getProducts() {
		ArrayList<Product> pAl = new ArrayList<>();
		for(int i=0; i<pCount; i++) {
			if(!(products[i] instanceof Refrigerator)) {
				pAl.add(products[i]);
			}
		}
		return pAl.toArray(new Product[pAl.size()]);
	}
	
	public Refrigerator[] getRefrigerator() {
		ArrayList<Product> pAl = new ArrayList<>();
		for(int i=0; i<pCount; i++) {
			if(products[i] instanceof Refrigerator) {
				pAl.add(products[i]);
			}
		}
		return pAl.toArray(new Refrigerator[pAl.size()]);
	}
	
	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {
		ArrayList<Product> pAl = new ArrayList<>();
		for(int i=0; i<pCount; i++) {
			if(products[i] instanceof Refrigerator) {
				Refrigerator fr = (Refrigerator) products[i];
				if(fr.isFreezer() == freezer) {
					pAl.add(products[i]);
				}
			}
		}
		return pAl.toArray(new Refrigerator[pAl.size()]);
	}
	
	public int sell(String pCode, int cnt) {
		Product p = searchByCode(pCode);
		if(p != null) {
			p.setQuantity(p.getQuantity() - cnt);
		}
		return p.getQuantity();
	}
}
