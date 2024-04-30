package com.houssem.microservices.orderservice.service;

import com.houssem.microservices.orderservice.dto.OrderRequest;

public interface IOrderService {
    void placeOrder(OrderRequest orderRequest);
}
