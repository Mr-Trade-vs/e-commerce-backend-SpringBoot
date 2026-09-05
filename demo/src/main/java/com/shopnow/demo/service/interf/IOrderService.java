package com.shopnow.demo.service.interf;

import com.shopnow.demo.dto.OrderDTO;
import com.shopnow.demo.model.Order;

public interface IOrderService {
    
    Order makePurchase(OrderDTO orderDTO);

    Order doPurchase(String id);

}
