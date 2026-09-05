package com.shopnow.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopnow.demo.dto.OrderDTO;
import com.shopnow.demo.model.Order;
import com.shopnow.demo.service.interf.IOrderService;

@RestController("/shop")
public class ControllerOrder {
    
    private IOrderService orderService;

    public ControllerOrder(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("purchase")
    public ResponseEntity<Order> startPurchase(@RequestBody OrderDTO orderDTO) {

        Order orderWasAdded = orderService.makePurchase(orderDTO);
        
        if (orderWasAdded == null) return ResponseEntity.badRequest().build();
    
        return ResponseEntity.ok(orderWasAdded);
        
    }

    @PostMapping("do")
    public ResponseEntity<Order> doPurchase(@RequestBody String idOrder) {


        return ResponseEntity.ok(null);

    }
}
