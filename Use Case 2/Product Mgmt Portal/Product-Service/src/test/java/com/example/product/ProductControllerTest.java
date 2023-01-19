package com.example.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.product.controller.ProductController;
import com.example.product.nonentity.ProductSaveRequest;
import com.example.product.service.impl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

	 @Mock
	 private ProductServiceImpl productService;
	
	 @InjectMocks
	 private ProductController controller;
	 
	 @Mock
	 ProductSaveRequest productSaveRequest;
	 
	 @Test
	 public void getAllProductsTest() {
		 Mockito.lenient().when(controller.getAllProducts()).thenReturn(null);
	 }
	 
	 @Test
	 public void getProductByIdTest() {
		 int id=1;
		 Mockito.lenient().when(controller.getProductId(id)).thenReturn(null);
	 }
	 
	 @Test
	 public void postEndpointToSaveDataTest() {		 
		 Mockito.lenient().when(controller.postEndpointToSaveData(productSaveRequest)).thenReturn(null);
	 }
	 
	 @Test
	 public void putEndpointToSaveDataTest() {		 
		 int id = 1;
		 Mockito.lenient().when(controller.putEndpointToSaveData(productSaveRequest, id)).thenReturn(null);
	 }
	 
	 @Test
	 public void deleteEndpointToDeleteProductTest() {		 
		 int id = 1;
		 Mockito.lenient().when(controller.deleteEndpointToDeleteProduct(id)).thenReturn(null);
	 }
	 
}
