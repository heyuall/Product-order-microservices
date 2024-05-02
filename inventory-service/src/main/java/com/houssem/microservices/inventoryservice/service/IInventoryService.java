package com.houssem.microservices.inventoryservice.service;

import org.springframework.transaction.annotation.Transactional;

public interface IInventoryService {
    @Transactional(readOnly = true)
    boolean isInStock(String skuCode, Integer quantity);
}
