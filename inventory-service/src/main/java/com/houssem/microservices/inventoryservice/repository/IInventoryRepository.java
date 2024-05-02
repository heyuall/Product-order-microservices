package com.houssem.microservices.inventoryservice.repository;

import com.houssem.microservices.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
