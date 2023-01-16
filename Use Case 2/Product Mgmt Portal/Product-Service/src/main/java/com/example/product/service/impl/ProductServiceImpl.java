package com.example.product.service.impl;

import com.example.product.entity.Product;
import com.example.product.enums.ErrorCodes;
import com.example.product.exception.GlobalException;
import com.example.product.nonentity.ProductSaveRequest;
import com.example.product.nonentity.Response;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository ;

    private static final String PRODUCT_SAVED_SUCCESSFULLY = "Saved data successfully";

    @Override
    public ResponseEntity saveProduct(ProductSaveRequest productSaveRequest) {
        try{
            Product product = Product.builder()
            		.name(productSaveRequest.getName())
            		.description(productSaveRequest.getDescription())
            		.price(productSaveRequest.getPrice())
            		.build();

            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(() -> {
            	productRepository.save(product);
            });
            Response response = Response.builder()
                    .status(HttpStatus.OK.value())
                    .message(PRODUCT_SAVED_SUCCESSFULLY)
                    .build();
            return ResponseEntity.ok(response);
            
        }
        catch (RuntimeException ex){
            log.info("Error saving data into database");
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }

    @Override
    public ResponseEntity updateProductEntity(ProductSaveRequest productSaveRequest, String name) {
        Optional<Product> optionalProduct = productRepository.findByName(name);

        Response response ;
        if(!optionalProduct.isPresent())
        {
            log.info("Empty product entity found");
            response = Response.builder()
                    .status(200)
                    .message("Data not found").build();
            return ResponseEntity.ok(response);
        }
        try {
            Product product = optionalProduct.get();
            updateBooksEntity(productSaveRequest, product);
            return ResponseEntity.ok(productRepository.save(product));
        }
        catch (Exception exception)
        {
            log.info("Error saving data into database");
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }
    private static void updateBooksEntity(ProductSaveRequest productSaveRequest, Product product) {
    	product.setName(productSaveRequest.getName());
    	product.setDescription(productSaveRequest.getDescription());
    	product.setPrice(productSaveRequest.getPrice());
    }
    
    @Override
    public ResponseEntity<Object> getAllProducts(){
        Object[] optionalProducts = productRepository.findAll().toArray();
        Response response ;
        if(optionalProducts.length == 0)
        {
            log.info("No products found");
            response = Response.builder()
                    .status(200)
                    .message("No Products found").build();
            return ResponseEntity.ok(response);
        }
        try {
            return ResponseEntity.ok(optionalProducts);
        }
        catch (Exception exception)
        {
            log.info("Error finding data into database");
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }

	@Override
	public ResponseEntity getProductByName(String name) {
		Optional<Product> optionalProduct = productRepository.findByName(name);
        Response response ;
        if(!optionalProduct.isPresent())
        {
            log.info("Empty product entity found");
            response = Response.builder()
                    .status(200)
                    .message("Data not found").build();
            return ResponseEntity.ok(response);
        }
        Product product = optionalProduct.get();
        return ResponseEntity.ok(product.getName());
	}
}
