package com.houssem.microservices.productservcie.service;

import com.houssem.microservices.productservcie.dto.ProductRequest;
import com.houssem.microservices.productservcie.dto.ProductResponse;
import com.houssem.microservices.productservcie.entity.Product;

import java.util.List;

public interface IProductService {
    Product createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
