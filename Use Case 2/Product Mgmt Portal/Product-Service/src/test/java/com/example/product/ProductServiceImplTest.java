package com.example.product;

import com.example.product.entity.DbSequence;
import com.example.product.entity.Product;
import com.example.product.exception.GlobalException;
import com.example.product.nonentity.ProductSaveRequest;
import com.example.product.nonentity.Response;
import com.example.product.repository.ProductRepository;
import com.example.product.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.mockito.internal.matchers.Any;
import com.example.product.service.impl.SequenceGeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    ProductRepository productRepository;

    @Mock
    ProductSaveRequest productSaveRequest;

    @Mock
    private SequenceGeneratorService sequenceGeneratorService;

    @Test
    public void getProductByIdWhenProductIsPresentTest(){
        int id = 1;
        Product product = Product.builder().id(1).build();
        Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(product));
        ResponseEntity responseEntity = productService.getProductById(id);
        
        assertEquals(product.getId(),responseEntity.getBody());
    }

    @Test
    public void getProductByIdWhenProductIsNotPresentTest(){
    	int id = 123;
        Product product = Product.builder().id(1).build();
        Mockito.when(productRepository.findById(id)).thenReturn(Optional.empty());
        ResponseEntity responseEntity = productService.getProductById(id);
        Response response = Response.builder()
                .status(500)
                .message("Data not found").build();
        assertEquals(response, responseEntity.getBody());
    }
    
    @Test
    public void getAllProductsWhenProductIsNotPresent(){
        List<Product> products = productRepository.findAll();
        Mockito.when(productRepository.findAll()).thenReturn(products);
        ResponseEntity responseEntity = productService.getAllProducts();
        Object response = responseEntity.getBody();
        Response response1 = Response.builder()
                .status(500)
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
                .status(500)
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
//    	lenient().when(sequenceGeneratorService.getSequenceNumber(any())).thenReturn(1);
        MockitoAnnotations.openMocks(this);
        Mockito.doReturn(1).when(sequenceGeneratorService).getSequenceNumber(any());
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

//    @Test
//    public void saveBookExceptionTest(){
//        BookSaveRequest bookSaveRequest = BookSaveRequest.builder()
//                .logo("abc")
//                .author("Rishav")
//                .price(100)
//                .active(true)
//                .publisher("XYZ")
//                .publishedDate(LocalDateTime.now())
//                .content("abc")
//                .category("Funny")
//                .title("Test").build();
//        String authorId = "abc";
//        Mockito.lenient().when(bookRepository.save(any())).thenThrow(new RuntimeException());
//        bookService.saveBook(bookSaveRequest,authorId);
////    }

}
