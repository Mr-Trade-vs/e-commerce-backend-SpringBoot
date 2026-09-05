package com.shopnow.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Order {
    
    @Id
    private String idOrder;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    private int quantity;
    private double totalToPay;
    private boolean purchaseDone;

    public Order(String idOrder, Product product, Customer customer, int quantity, double totalToPay,
            boolean purchaseDone) {
        this.idOrder = idOrder;
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
        this.totalToPay = totalToPay;
        this.purchaseDone = purchaseDone;
    }

    public Order() {
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getcustomer() {
        return customer;
    }

    public void setcustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(double totalToPay) {
        this.totalToPay = totalToPay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isPurchaseDone() {
        return purchaseDone;
    }

    public void setPurchaseDone(boolean purchaseDone) {
        this.purchaseDone = purchaseDone;
    }

}
