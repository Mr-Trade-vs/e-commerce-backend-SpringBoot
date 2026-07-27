package com.shopnow.demo.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStore extends JpaRepository<Product, String> {

    Optional<Product> findTopByOrderByIdDesc();
    
}
