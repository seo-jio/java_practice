package assignment.java_hw_07_4.com.ssafy.hw.step4;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductManagerImpl implements IProductManager{

    public static final int MAX_PRODUCT_SIZE = 100;
    public static final int MAX_REVIEW_SIZE = 100;
    private Product[] products;
    private Review[] reviews;
    private int pCount = 0;
    private int rCount = 0;
    private static ProductManagerImpl pm = new ProductManagerImpl();

    private ProductManagerImpl(){
        products = new Product[MAX_PRODUCT_SIZE];
        reviews = new Review[MAX_REVIEW_SIZE];
    }

    public static ProductManagerImpl getInstance(){
        return pm;
    }

    @Override
    public boolean addProduct(Product product) {
        Product p = searchByCode(product.getpCode());
        if(p == null){
            products[pCount++] = product;
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        for(int i=0; i<pCount; i++){
            if(products[i].getpCode().equals(product.getpCode())){
                products[i] = product;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeProduct(String pCode) {
        for(int i=0; i<pCount; i++){
            if(products[i].getpCode().equals(pCode)){
                products[i] = products[pCount--];
                return true;
            }
        }
        return false;
    }

    @Override
    public int sell(String pCode, int cnt) {
        int rest = 0;
        for(int i=0; i<pCount; i++) {
            if (products[i].getpCode().equals(pCode)) {
                rest = products[i].getQuantity() - cnt;
                products[i].setQuantity(rest);
            }
        }
        return rest;
    }

    @Override
    public Product[] getProductList() {
        return Arrays.copyOf(products, pCount);
    }

    @Override
    public Product searchByCode(String pCode) {
        for(int i=0; i<pCount; i++){
            if(products[i].getpCode().equals(pCode)){
                return products[i];
            }
        }
        return null;
    }

    public Review searchById(int reviewId){
        for(int i=0; i<rCount; i++){
            if(reviews[i].getReviewId() == reviewId){
                return reviews[i];
            }
        }
        return null;
    }

    @Override
    public boolean addReview(Review review) {
        Review r = searchById(review.getReviewId());
        if(r == null){
            reviews[rCount++] = review;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeReview(int reviewId) {
        for(int i=0; i<rCount; i++){
            if(reviews[i].getReviewId() == reviewId){
                reviews[i] = reviews[rCount--];
                return true;
            }
        }
        return false;
    }

    @Override
    public Review[] getProductReview(String pCode) {
        List<Review> rs = new ArrayList<>();
        for(int i=0; i<rCount; i++){
            if(reviews[i].getpCode().equals(pCode)){
                rs.add(reviews[i]);
            }
        }
        return rs.toArray(new Review[0]);
    }

    @Override
    public Product[] searchByName(String name) {
        List<Product> ps = new ArrayList<>();
        for(int i=0; i<pCount; i++){
            if(products[i].getpName().contains(name)){
                ps.add(products[i]);
            }
        }
        return ps.toArray(new Product[0]);
    }

    @Override
    public long getTotalPrice() {
        long sum = 0;
        for(int i=0; i<pCount; i++){
            sum += products[i].getPrice();
        }
        return sum;
    }

    @Override
    public Product[] getProducts() {
        List<Product> ps = new ArrayList<>();
        for(int i=0; i<pCount; i++){
            if(!(products[i] instanceof Refrigerator)){
                ps.add(products[i]);
            }
        }
        return ps.toArray(new Product[0]);
    }

    @Override
    public Refrigerator[] getRefrigerator() {
        List<Refrigerator> rs = new ArrayList<>();
        for(int i=0; i<pCount; i++){
            if(products[i] instanceof Refrigerator){
                rs.add((Refrigerator)products[i]);
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
