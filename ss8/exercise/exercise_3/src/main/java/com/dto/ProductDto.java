package com.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ProductDto {
    private int id;
    @NotEmpty(message = "Khong duoc de trong")
    private String productName;
    @NotEmpty(message = "Khong duoc de trong")
    private String productPrice;
    @NotEmpty(message = "Khong duoc de trong")
    private String producer;

    public ProductDto() {
    }

    public ProductDto(int id, String productName, String productPrice, String producer) {
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
