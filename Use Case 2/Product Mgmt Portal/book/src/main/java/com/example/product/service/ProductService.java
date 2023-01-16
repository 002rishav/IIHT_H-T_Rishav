package com.example.product.service;

import org.springframework.http.ResponseEntity;

import com.example.product.nonentity.ProductSaveRequest;

public interface ProductService {

    public ResponseEntity saveProduct(ProductSaveRequest bookSaveRequest);

    public ResponseEntity updateProductEntity(ProductSaveRequest bookSaveRequest , String name);

    public ResponseEntity<Object> getAllProducts();
    
    public ResponseEntity getProductByName(String name);
}
