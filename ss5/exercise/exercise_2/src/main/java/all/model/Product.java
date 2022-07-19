package all.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    private int id;
    private String productName;
    private String productPrice;
    private String producer;

    public Product() {
    }

    public Product(int id, String productName, String productPrice, String producer) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}