package com.shopnow.demo.service.interf;

import com.shopnow.demo.dto.CustomerDTO;
import com.shopnow.demo.model.Customer;

public interface ICustomerService {

    Customer addCustomer(CustomerDTO customerDTO);

    Customer findCustomer(String id);
}
