package com.shopnow.demo.dto;

public class OrderDTO {
    
    private int quantity;
    private String idProduct;
    private String idCustomer;

    public OrderDTO(int quantity, String idProduct, String idCustomer) {
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.idCustomer = idCustomer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

}
