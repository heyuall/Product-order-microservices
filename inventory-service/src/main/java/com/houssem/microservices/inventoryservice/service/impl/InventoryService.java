package com.houssem.microservices.inventoryservice.service.impl;

import com.houssem.microservices.inventoryservice.repository.IInventoryRepository;
import com.houssem.microservices.inventoryservice.service.IInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService implements IInventoryService {

    private final IInventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}