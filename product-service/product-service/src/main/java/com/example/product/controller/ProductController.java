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

    @GetMapping("/api/v1/AllProducts")
    public ResponseEntity<Object> getAllProducts(){
        return productService.getAllProducts();
    }
    
    @GetMapping("/api/v1/{id}")
    public ResponseEntity getProductId(@PathVariable("id") int id){
        return productService.getProductById(id);
    }

    @PostMapping("/api/v1")
    public ResponseEntity postEndpointToSaveData(@RequestBody ProductSaveRequest productSaveRequest){
        return productService.saveProduct(productSaveRequest);
    }

    @PutMapping("/api/v1/{id}")
    public ResponseEntity putEndpointToSaveData(@RequestBody ProductSaveRequest productSaveRequest , @PathVariable("id") int id){
        return productService.updateProductEntity(productSaveRequest, id);
    }
    
    @DeleteMapping("/api/v1/{id}")
    public ResponseEntity deleteEndpointToDeleteProduct(@PathVariable("id") int id){
        return productService.deleteProduct(id);
    }
}
