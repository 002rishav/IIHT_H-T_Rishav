package com.user.controller;

import com.user.constraints.ProductConstraint;
import com.user.output.SaveProductResponse;
import com.user.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final IProductService productServiceImpl;

    @GetMapping(value="/api/v1/AllProducts", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Merchant')")
    public Object getAllProducts(){
        return productServiceImpl.getAllProducts();
    }

    @PostMapping(value="/api/v1",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Merchant')")
    public ResponseEntity postEndpointToSaveData(@ProductConstraint @RequestBody SaveProductResponse saveProductResponse){
        return productServiceImpl.saveProduct(saveProductResponse);
    }

    @PutMapping(value="/api/v1/{id}",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Merchant')")
    public ResponseEntity putEndpointToUpdateData(@ProductConstraint @RequestBody SaveProductResponse saveProductResponse, @PathVariable("id") int id){
        return productServiceImpl.updateProduct(saveProductResponse , id);
    }
    
    @DeleteMapping(value="/api/v1/{id}",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Merchant')")
    public ResponseEntity deleteData(@PathVariable("id") int id){
        return productServiceImpl.deleteProduct(id);
    }
}
