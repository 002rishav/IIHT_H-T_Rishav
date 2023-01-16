package com.example.product.controller;

import com.example.product.nonentity.ProductSaveRequest;
import com.example.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService ;

    @GetMapping("/api/v1/getAllProducts")
    public ResponseEntity<Object> getAllProducts(){
        return productService.getAllProducts();
    }
    
    @GetMapping("/api/v1/getProduct/{name}")
    public ResponseEntity getProductByName(@PathVariable("name") String name){
        return productService.getProductByName(name);
    }

    @PostMapping("/api/v1/save/products")
    public ResponseEntity postEndpointToSaveData(@RequestBody ProductSaveRequest productSaveRequest){
        return productService.saveProduct(productSaveRequest);
    }

    @PutMapping("/api/v1/update/products/{name}")
    public ResponseEntity putEndpointToSaveData(@RequestBody ProductSaveRequest productSaveRequest , @PathVariable("name") String name){
        return productService.updateProductEntity(productSaveRequest, name);
    }
}
