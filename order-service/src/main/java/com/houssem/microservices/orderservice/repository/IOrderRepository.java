package com.houssem.microservices.orderservice.repository;

import com.houssem.microservices.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
