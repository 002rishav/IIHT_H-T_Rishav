package com.example.product.service;

import org.springframework.http.ResponseEntity;

import com.example.product.nonentity.ProductSaveRequest;

public interface ProductService {

    public ResponseEntity saveProduct(ProductSaveRequest productSaveRequest);

    public ResponseEntity updateProductEntity(ProductSaveRequest productSaveRequest , int id);
    
    public ResponseEntity deleteProduct(int id);

    public ResponseEntity<Object> getAllProducts();
    
    public ResponseEntity getProductById(int id);
}
