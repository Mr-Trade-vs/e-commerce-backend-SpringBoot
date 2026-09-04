package com.shopnow.demo.dto;

public class OrderDTO {
    
    private int quantity;
    private double totalToPay;
    
    public OrderDTO(int quantity, double totalToPay) {
        this.quantity = quantity;
        this.totalToPay = totalToPay;
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
}
