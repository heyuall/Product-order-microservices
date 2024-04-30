package com.houssem.microservices.productservcie.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    @Test
    void test_string_template_java21() {
        String name = "Alice";
        int age = 30;
        String message = STR."Hello, my name is \{name} and I am \{age} years old.";
        System.out.println(message);
    }
}