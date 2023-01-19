package com.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.user.controller.ProductController;
import com.user.output.SaveProductResponse;
import com.user.service.IProductService;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

	@InjectMocks
	private ProductController productController;
	
	@Mock
	private IProductService productServiceImpl;
	
	@Mock
	private SaveProductResponse saveProductResponse;
	
	@Test
	public void getAllProductsTest() {
		Mockito.lenient().when(productController.getAllProducts()).thenReturn(null);
	}
	
	@Test
	public void postEndpointToSaveDataTest() {
		Mockito.lenient().when(productController.postEndpointToSaveData(saveProductResponse)).thenReturn(null);
	}
	
	@Test
	public void putEndpointToUpdateDataTest() {
		int id = 1;
		Mockito.lenient().when(productController.putEndpointToUpdateData(saveProductResponse,id)).thenReturn(null);
	}
	
	@Test
	public void deleteProductTest() {
		int id = 1;
		Mockito.lenient().when(productController.deleteData(id)).thenReturn(null);
	}
}
