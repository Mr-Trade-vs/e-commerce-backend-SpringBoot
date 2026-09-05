package com.shopnow.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopnow.demo.model.Order;

public interface IOrderRepository extends JpaRepository<Order, String> {
    
    Optional<Order> findTopByOrderByIdDesc();
    
}
