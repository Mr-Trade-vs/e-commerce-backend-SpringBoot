package com.shopnow.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopnow.demo.model.Product;

@Repository
public interface IProductStore extends JpaRepository<Product, String> {

    Optional<Product> findTopByOrderByIdDesc();
    
}
