package com.shopnow.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopnow.demo.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, String> {
    
    Optional<Customer> findTopByOrderByIdDesc();
}
