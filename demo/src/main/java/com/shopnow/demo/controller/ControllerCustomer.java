package com.shopnow.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopnow.demo.dto.CustomerDTO;
import com.shopnow.demo.model.Customer;
import com.shopnow.demo.service.interf.ICustomerService;

@RestController("/customer")
public class ControllerCustomer {
    
    private ICustomerService customerService;

    public ControllerCustomer(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO) {

        Customer customerResponse = customerService.addCustomer(customerDTO);
        
        return ResponseEntity.ok(customerResponse);
    }
}
