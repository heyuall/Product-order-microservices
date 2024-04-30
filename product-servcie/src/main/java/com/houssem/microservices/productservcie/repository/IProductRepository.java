package com.houssem.microservices.productservcie.repository;

import com.houssem.microservices.productservcie.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Product, String> {
}
