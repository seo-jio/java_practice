package com.ssafy.hw.step4;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ProductManagerImpl implements IProductManager{

    private List<Product> products;
    private Map<String, List<Review>> reviews;
    private static ProductManagerImpl pm = new ProductManagerImpl();

    private ProductManagerImpl(){
        products = new ArrayList<>();
        reviews = new HashMap();
    }

    public static ProductManagerImpl getInstance(){
        return pm;
    }

    @Override
    public boolean addProduct(Product product) {
        Product p = searchByCode(product.getpCode());
        if(p == null){
            products.add(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getpCode().equals(product.getpCode())){
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeProduct(String pCode) {
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getpCode().equals(pCode)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int sell(String pCode, int cnt) {
        int rest = 0;
        for(int i=0; i<products.size(); i++) {
            if (products.get(i).getpCode().equals(pCode)) {
                rest = products.get(i).getQuantity() - cnt;
                products.get(i).setQuantity(rest);
            }
        }
        return rest;
    }

    @Override
    public Product[] getProductList() {
    	return products.toArray(new Product[0]);
    }

    @Override
    public Product searchByCode(String pCode) {
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getpCode().equals(pCode)){
                return products.get(i);
            }
        }
        return null;
    }

    public Review searchById(int reviewId){
        for(Entry<String, List<Review>> entry : reviews.entrySet()) {
        	for(Review r : entry.getValue()) {
        		if(r.getReviewId() == reviewId) {
        			return r;
        		}
        	}
        }
        return null;
    }

    @Override
    public boolean addReview(Review review) {
        Review r = searchById(review.getReviewId());
        if(r == null){
            int flag = 0;
            for(String s : reviews.keySet()) {
            	if(s.equals(review.getpCode())) {
            		flag = 1;
            		break;
            	}
            }
            System.out.println("flag : " + flag);
            if(flag == 1) { //상품에 대한 리뷰가 이미 존재할 경우
            	reviews.get(review.getpCode()).add(review);
            } else { //상품에 대한 첫 리뷰일 경우
            	List<Review> tmp = new ArrayList<>();
            	tmp.add(review);
            	reviews.put(review.getpCode(), tmp);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean removeReview(int reviewId) {
        for(Entry<String, List<Review>> entry : reviews.entrySet()){
        	for(Review r : entry.getValue()) {
        		if(r.equals(new Review(reviewId))) {
        			entry.getValue().remove(r);
        			return true;
        		}
        	}
        }
        return false;
    }

    @Override
    public Review[] getProductReview(String pCode) {
        return reviews.get(pCode).toArray(new Review[0]);
    }

    @Override
    public Product[] searchByName(String name) {
        List<Product> ps = new ArrayList<>();
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getpName().contains(name)){
                ps.add(products.get(i));
            }
        }
        return ps.toArray(new Product[0]);
    }

    @Override
    public long getTotalPrice() {
        long sum = 0;
        for(int i=0; i<products.size(); i++){
            sum += products.get(i).getPrice();
        }
        return sum;
    }

    @Override
    public Product[] getProducts() {
        List<Product> ps = new ArrayList<>();
        for(int i=0; i<products.size(); i++){
            if(!(products.get(i) instanceof Refrigerator)){
                ps.add(products.get(i));
            }
        }
        return ps.toArray(new Product[0]);
    }

    @Override
    public Refrigerator[] getRefrigerator() {
        List<Refrigerator> rs = new ArrayList<>();
        for(int i=0; i<products.size(); i++){
            if(products.get(i) instanceof Refrigerator){
                rs.add((Refrigerator)products.get(i));
            }
        }
        return rs.toArray(new Refrigerator[0]);
    }

    @Override
    public Refrigerator[] getRefrigeratorFreezer(boolean freezer) {
        Refrigerator[] rs = getRefrigerator();
        List<Refrigerator> rfs = new ArrayList<>();
        for(Refrigerator r : rs){
            if(r.isFreezer() == true){
                rfs.add(r);
            }
        }
        return rfs.toArray(new Refrigerator[0]);
    }
}
