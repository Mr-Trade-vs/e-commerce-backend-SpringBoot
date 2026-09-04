package com.shopnow.demo.dto;

public class ProductDTO {

    private String name;
    private double unitaryPrice;
    private int stock;
    
    public ProductDTO(String name, double unitaryPrice, int stock) {
        this.name = name;
        this.unitaryPrice = unitaryPrice;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
