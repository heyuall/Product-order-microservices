package com.houssem.microservices.orderservice.service.impl;

import com.houssem.microservices.orderservice.client.InventoryClient;
import com.houssem.microservices.orderservice.dto.OrderRequest;
import com.houssem.microservices.orderservice.entity.Order;
import com.houssem.microservices.orderservice.repository.IOrderRepository;
import com.houssem.microservices.orderservice.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        boolean inStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (inStock) {
            var order = mapToOrder(orderRequest);
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with Skucode " + orderRequest.skuCode() + "is not in stock");
        }
    }

    private static Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        return order;
    }
}