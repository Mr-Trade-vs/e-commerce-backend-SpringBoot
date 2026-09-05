package com.shopnow.demo.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shopnow.demo.dto.OrderDTO;
import com.shopnow.demo.model.Customer;
import com.shopnow.demo.model.Order;
import com.shopnow.demo.model.Product;
import com.shopnow.demo.repository.IOrderRepository;
import com.shopnow.demo.service.interf.ICustomerService;
import com.shopnow.demo.service.interf.IOrderService;
import com.shopnow.demo.service.interf.IProductService;

@Service
public class OrderService implements IOrderService{
    
    private final IOrderRepository orderRepository;
    private final ICustomerService customerService;
    private final IProductService productService;

    public OrderService(IOrderRepository orderRepository, ICustomerService customerService,
            IProductService productService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
    }

    @Override
    public Order makePurchase(OrderDTO orderDTO) {

        Product foundProduct = productService.findProduct(orderDTO.getIdProduct());
        if (foundProduct == null) return null;
        Customer foundCustomer = customerService.findCustomer(orderDTO.getIdCustomer());
        if (foundCustomer == null) return null;

        if (!canPurchase(foundProduct.getStock(), orderDTO.getQuantity())) return null;
        
        double totalToPay = orderDTO.getQuantity() * foundProduct.getUnitaryPrice();

        Order orderToAdd = new Order(null, foundProduct, foundCustomer, orderDTO.getQuantity(), totalToPay);
        orderToAdd = idGeneration(orderToAdd);
        return orderToAdd;
        
    }

    private Order idGeneration(Order orderToUpdate) {
        
        if (orderToUpdate == null) return null;

        Optional<Order> lastOrder = orderRepository.findTopByOrderByIdDesc();

        if (lastOrder.isEmpty()) {
            orderToUpdate.setIdOrder("O00000001");
            return orderToUpdate;
        }

        String lastId = lastOrder.get().getIdOrder();
        int nextId = Integer.parseInt(lastId.substring(1));
        nextId++;

        orderToUpdate.setIdOrder(String.format("O%07d", nextId));
        return orderToUpdate;

    }

    private boolean canPurchase(int stock, int purchase) {

        if (stock < 0 || purchase < 0 || purchase > stock) return false;

        return true;
    }

}
