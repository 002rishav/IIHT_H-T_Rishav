package com.user.controller;

import com.user.output.SaveProductResponse;
import com.user.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productServiceImpl;

    @GetMapping(value="/getAllProducts", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Merchant')")
    public Object getAllProducts(){
        return productServiceImpl.getAllProducts();
    }

    @PostMapping(value="/save",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Merchant')")
    public ResponseEntity postEndpointToSaveData(@RequestBody SaveProductResponse saveProductResponse){
        return productServiceImpl.saveProduct(saveProductResponse);
    }

    @PutMapping(value="/update/{name}",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Merchant')")
    public ResponseEntity putEndpointToUpdateData(@RequestBody SaveProductResponse saveProductResponse, @PathVariable("name") String name){
        return productServiceImpl.updateProduct(saveProductResponse , name);
    }
}
