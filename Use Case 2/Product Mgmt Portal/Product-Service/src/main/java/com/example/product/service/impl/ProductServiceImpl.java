package com.example.product.service.impl;

import com.example.product.entity.Product;
import com.example.product.enums.ErrorCodes;
import com.example.product.exception.GlobalException;
import com.example.product.nonentity.ProductSaveRequest;
import com.example.product.nonentity.Response;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import com.example.product.utility.SequenceGenerator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository ;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    private static final String PRODUCT_SAVED_SUCCESSFULLY = "Saved data successfully";

    @Override
    public ResponseEntity saveProduct(ProductSaveRequest productSaveRequest) {
        try{
            Product product = Product.builder()
            		.id(sequenceGenerator.getSequenceNumber(Product.SEQUENCE_NAME))
            		.name(productSaveRequest.getName())
            		.description(productSaveRequest.getDescription())
            		.price(productSaveRequest.getPrice())
            		.build();

            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(() -> {
            	productRepository.save(product);
            });

            Response response = Response.builder()
                    .status(HttpStatus.CREATED.value())
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
    public ResponseEntity updateProductEntity(ProductSaveRequest productSaveRequest, int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        Response response ;
        if(!optionalProduct.isPresent())
        {
            log.info("Empty product entity found");
            response = Response.builder()
                    .status(404)
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
                    .status(404)
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
	public ResponseEntity getProductById(int id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
        Response response ;
        if(!optionalProduct.isPresent())
        {
            log.info("Empty product entity found");
            response = Response.builder()
                    .status(404)
                    .message("Data not found").build();
            return ResponseEntity.ok(0);
        }
        Product product = optionalProduct.get();
        return ResponseEntity.ok(product.getId());
	}

	@Override
	public ResponseEntity deleteProduct(int id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		Response response ;
		if(!optionalProduct.isPresent())
        {
            log.info("Empty product entity found");
            response = Response.builder()
                    .status(404)
                    .message("Data not found").build();
            return ResponseEntity.ok(response);
        }
		productRepository.deleteById(id);
		response = Response.builder()
                .status(204)
                .message("Product Deleted").build();
		return ResponseEntity.ok(response);
	}
}
