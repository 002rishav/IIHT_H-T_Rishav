package com.example.product;

import com.example.product.entity.Product;
import com.example.product.exception.GlobalException;
import com.example.product.nonentity.ProductSaveRequest;
import com.example.product.nonentity.Response;
import com.example.product.repository.ProductRepository;
import com.example.product.service.impl.ProductServiceImpl;
import com.example.product.utility.SequenceGenerator;

import org.mockito.*;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;
    
    @Mock
    ProductRepository productRepository;

    @Mock
    ProductSaveRequest productSaveRequest;

    @Mock
    private SequenceGenerator sequenceGenerator;

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    @Test
    public void getProductByIdWhenProductIsPresentTest(){
        int id = 1;
        Product product = Product.builder().id(1).build();
        Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(product));
        ResponseEntity responseEntity = productService.getProductById(id);
        
        assertEquals(product.getId(),responseEntity.getBody());
    }

//    @Test
//    public void getProductByIdWhenProductIsNotPresentTest(){
//    	int id = 123;
//        Product product = Product.builder().id(1).build();
//        Mockito.when(productRepository.findById(id)).thenReturn(Optional.empty());
//        ResponseEntity responseEntity = productService.getProductById(id);
//
//        Response responseout = Response.builder()
//                 .status(404)
//                 .message("Data not found").build();
//        Response response = Response.builder()
//                .status(404)
//                .message("Data not found").build();
//		assertEquals(response, responseout);
//    }
    
    @Test
    public void getAllProductsWhenProductIsNotPresent(){
        List<Product> products = productRepository.findAll();
        Mockito.when(productRepository.findAll()).thenReturn(products);
        ResponseEntity responseEntity = productService.getAllProducts();
        Object response = responseEntity.getBody();
        Response response1 = Response.builder()
                .status(404)
                .message("No Products found").build();
        assertEquals(response1,response);
    }

    @Test
    public void getAllProductsWhenProductIsPresent(){
        
        ProductSaveRequest productSaveRequest = ProductSaveRequest.builder()
                .name("XYZ")
                .description("ABC")
                .price(1000).build();
        Product product = Product.builder().name("XYZ")
                .description("ABC")
                .price(1000).build();
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        Object[] objects = new Object[productList.size()];
        objects[0] = product;
        Mockito.when(productRepository.findAll()).thenReturn(productList);
        ResponseEntity responseEntity = productService.getAllProducts();
        Object[] response = (Object[]) responseEntity.getBody();
    }

    @Test
    public void updateProductWhenProductIsNotPresent() {
    	ProductSaveRequest productSaveRequest = ProductSaveRequest.builder()
                .name("XYZ")
                .description("ABC")
                .price(1000).build();
    	int id = 1;
    	Optional<Product> optionalProduct = productRepository.findById(id);
        Mockito.lenient().when(productRepository.findById(id)).thenReturn(Optional.empty());
        ResponseEntity responseEntity = productService.updateProductEntity(productSaveRequest, id);
        Object response = responseEntity.getBody();
        Response response1 = Response.builder()
                .status(404)
                .message("Data not found").build();
        assertEquals(response1,response);
    }
    
    @Test
    public void updateProductWhenProductIsPresent() {
    	ProductSaveRequest productSaveRequest = ProductSaveRequest.builder()
                .name("XYZ")
                .description("ABC")
                .price(1000).build();
    	int id = 1;
    	Product product = Product.builder().build();
        Mockito.lenient().when(productRepository.findById(id)).thenReturn(Optional.of(product));
        ResponseEntity responseEntity = productService.updateProductEntity(productSaveRequest, id);
    }
    
    @Test
    public void saveProductTest(){
//    	lenient().when(sequenceGenerator.getSequenceNumber(any())).thenReturn(1);
        MockitoAnnotations.openMocks(this);
        Mockito.doReturn(1).when(sequenceGenerator).getSequenceNumber(any());
        Product mockProduct = Product.builder().id(1).name("XYZ")
                .description("ABC")
                .price(1000).build();
        Mockito.lenient().when(productRepository.save(any())).thenReturn(mockProduct);
        ResponseEntity responseEntity = productService.saveProduct(productSaveRequest);
        Response response = Response.builder()
                .status(HttpStatus.CREATED.value())
                .message("Saved data successfully")
                .build();
        assertEquals(response,responseEntity.getBody());
    }
    
    @Test
    public void saveProductExceptionTest() {
//    	Mockito.doReturn(1).when(sequenceGenerator).getSequenceNumber(any());
        Product mockProduct = Product.builder().id(1).name("XYZ")
                .description("ABC")
                .price(1000).build();
        Mockito.lenient().when(productRepository.save(any())).thenReturn(mockProduct);
//        exception.expect(GlobalException.class);
//        ResponseEntity responseEntity = productService.saveProduct(productSaveRequest);
        Assertions.assertThrows(GlobalException.class, () -> productService.saveProduct(productSaveRequest));       
    }

	@Test
    public void deleteProductWhenProductIsPresentTest() {
    	int id = 1;
    	Product product = Product.builder().build();
        Mockito.lenient().when(productRepository.findById(id)).thenReturn(Optional.of(product));
        ResponseEntity responseEntity = productService.deleteProduct(id);
        Response response = Response.builder()
                .status(204)
                .message("Product Deleted").build();
        assertEquals(response,responseEntity.getBody());
    }
    
    @Test
    public void deleteProductWhenProductIsNotPresentTest() {
    	int id = 1;
        Mockito.lenient().when(productRepository.findById(id)).thenReturn(Optional.empty());
        ResponseEntity responseEntity = productService.deleteProduct(id);
        Response response = Response.builder()
                .status(404)
                .message("Data not found").build();
        assertEquals(response,responseEntity.getBody());
    }

}
