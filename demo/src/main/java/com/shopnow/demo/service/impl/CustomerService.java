package com.shopnow.demo.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shopnow.demo.dto.CustomerDTO;
import com.shopnow.demo.model.Customer;
import com.shopnow.demo.repository.ICustomerRepository;
import com.shopnow.demo.service.interf.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(CustomerDTO customerDTO) {

        if (customerDTO == null) return null;
        
        if (customerDTO.getName().isEmpty() || customerDTO.getMail().isEmpty() || customerDTO.getPhone().isEmpty()) return null;

        Customer customerToAdd = new Customer(null, customerDTO.getName(), customerDTO.getMail(), customerDTO.getPhone());
        customerToAdd = idGeneration(customerToAdd);

        customerRepository.save(customerToAdd);
        return customerToAdd;
    }

    @Override
    public Customer findCustomer(String id) {

        Optional<Customer> foundCustomer = customerRepository.findById(id);
        Customer customer = foundCustomer.orElse(null);

        return customer;

    }

    private Customer idGeneration(Customer customerNeedId) {

        Optional<Customer> lastCustomer = customerRepository.findTopByOrderByIdDesc();

        if (lastCustomer.isEmpty()) {
            customerNeedId.setId("C00001");
            return customerNeedId;
        }

        String actualId = lastCustomer.get().getId();
        int nextId = Integer.parseInt(actualId.substring(1));
        nextId++;

        customerNeedId.setId(String.format("C%04d", nextId));
        return customerNeedId;
    }
    
}
