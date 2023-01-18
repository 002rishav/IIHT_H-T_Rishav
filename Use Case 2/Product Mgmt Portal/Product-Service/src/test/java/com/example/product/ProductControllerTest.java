package com.example.product;

import static org.hamcrest.CoreMatchers.any;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.product.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
	
	 @Mock
	 private ProductService productService;
	 
	 @Test
	 public void getMappingTest() {

		 Mockito.when(productService.getAllProducts()).thenReturn(null);
	 }
	 
}
