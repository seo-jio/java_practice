package com.ssafy.hw.step4;

public interface IProductManager {
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean removeProduct(String pCode);
    int sell(String pCode, int cnt) throws ProductCodeNotFoundException, QuantityException;
    int buy(String pCode, int quantity) throws ProductCodeNotFoundException;
    Product[] getProductList();
    Product searchByCode(String pCode);
    boolean addReview(Review review);
    boolean removeReview(int reviewId);
    Review[] getProductReview(String pCode);
    Product[] searchByName(String name);
    long getTotalPrice();
    Product[] getProducts();
    Refrigerator[] getRefrigerator();
    Refrigerator[] getRefrigeratorFreezer(boolean freezer);
}
