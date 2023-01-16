package com.user.service;

import com.user.output.SaveProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    public Object getAllProducts();

    public ResponseEntity saveProduct(SaveProductResponse saveProductResponse);

    public ResponseEntity updateProduct(SaveProductResponse saveProductResponse, String name);
}
