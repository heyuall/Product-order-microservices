package com.houssem.microservices.productservcie.service.impl;

import com.houssem.microservices.productservcie.dto.ProductRequest;
import com.houssem.microservices.productservcie.dto.ProductResponse;
import com.houssem.microservices.productservcie.entity.Product;
import com.houssem.microservices.productservcie.repository.IProductRepository;
import com.houssem.microservices.productservcie.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        product = this.productRepository.save(product);
        log.info("Product {} is saved", product.getId());
        return product;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }
}
