package com.example.book;

import com.example.product.entity.Product;
import com.example.product.nonentity.ProductSaveRequest;
import com.example.product.nonentity.Response;
import com.example.product.repository.ProductRepository;
import com.example.product.service.impl.ProductServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @InjectMocks
    private ProductServiceImpl bookService;
    @Mock
    ProductRepository bookRepository;

    @Mock
    ProductSaveRequest bookSaveRequest;

    @Test
    public void searchBookWhenBookIsPresentTest(){
        String category = "Funny";
        String title = "Toy Story";
        String author = "Rishav";
        int price = 600;
        String publisher = "XYZ";

        Product book = Product.builder().id(1).bookId("Book123").category("Funny").title("Toy Story").author("Rishav").price(600).publisher("XYZ").build();
        List<Product> booksList = new ArrayList<>();
        booksList.add(book);
        Mockito.when(bookRepository.findByCategoryOrTitleOrAuthorOrPriceOrPublisher(category,title,author,price,publisher)).thenReturn(Optional.of(booksList));
        ResponseEntity responseEntity = bookService.searchBook(category,title,author,price,publisher);
        Optional<List<Product>> optionalBooksList = (Optional<List<Product>>) responseEntity.getBody();
        assertEquals(booksList,optionalBooksList.get());
    }

    @Test
    public void searchBookWhenBookIsNotPresentTest(){
        String category = "Funny";
        String title = "Toy Story";
        String author = "Rishav";
        int price = 600;
        String publisher = "XYZ";

        Product book = Product.builder().id(1).bookId("Book123").category("Funny").title("Toy Story").author("Rishav").price(600).publisher("XYZ").build();
        List<Product> booksList = new ArrayList<>();
        booksList.add(book);
        Mockito.when(bookRepository.findByCategoryOrTitleOrAuthorOrPriceOrPublisher(category,title,author,price,publisher)).thenReturn(Optional.empty());
        ResponseEntity responseEntity = bookService.searchBook(category,title,author,price,publisher);
        Response response = Response.builder()
                .status(200)
                .message("Data not found").build();
        assertEquals(response,(Response) responseEntity.getBody());
    }

    @Test
    public void activeStatusWhenBookIsPresentTest(){
        String bookId = "Book123";
        Product book = Product.builder().id(1).bookId("Book123").active(true).build();
        Mockito.when(bookRepository.findByBookId(bookId)).thenReturn(Optional.of(book));
        ResponseEntity responseEntity = bookService.activeStatus(bookId);
        boolean status = (boolean) responseEntity.getBody();
        assertEquals(book.isActive(),status);
    }

    @Test
    public void activeStatusWhenBookIsNotPresentTest(){
        String bookId = "Book123";
        Product book = Product.builder().id(1).bookId("Book123").active(true).build();
        Mockito.when(bookRepository.findByBookId(bookId)).thenReturn(Optional.empty());
        ResponseEntity responseEntity = bookService.activeStatus(bookId);
        Response response = Response.builder()
                .status(200)
                .message("Data not found").build();
        assertEquals(response, (Response) responseEntity.getBody());
    }

    @Test
    public void getBookContentWhenBookIsPresentTest(){
        String bookId = "Book123";
        Product book = Product.builder().id(1).bookId("Book123").active(true).build();
        Mockito.when(bookRepository.findByBookId(bookId)).thenReturn(Optional.of(book));
        ResponseEntity responseEntity = bookService.getBookContent(bookId);
        Product books = (Product) responseEntity.getBody();
        assertEquals(book, books);
    }

    @Test
    public void getBookContentWhenBookIsNotPresentTest(){
        String bookId = "Book123";
        Product book = Product.builder().id(1).bookId("Book123").active(true).build();
        Mockito.when(bookRepository.findByBookId(bookId)).thenReturn(Optional.empty());
        ResponseEntity responseEntity = bookService.getBookContent(bookId);
        Response response = Response.builder()
                .status(200)
                .message("Data not found").build();
        assertEquals(response, (Response) responseEntity.getBody());
    }

    @Test
    public void getBookByBookIdWhenBookIsPresentTest(){
        String bookId = "Book123";
        Product book = Product.builder().id(1).bookId("Book123").active(true).build();
        Mockito.when(bookRepository.findByBookId(bookId)).thenReturn(Optional.of(book));
        ResponseEntity responseEntity = bookService.getBookByBookId(bookId);
        String books = responseEntity.getBody().toString();
        assertEquals(book.getBookId(),books);
    }

    @Test
    public void getBookByBookIdWhenBookIsNotPresentTest(){
        String bookId = "Book123";
        Product book = Product.builder().id(1).bookId("Book123").active(true).build();
        Mockito.when(bookRepository.findByBookId(bookId)).thenReturn(Optional.empty());
        ResponseEntity responseEntity = bookService.getBookByBookId(bookId);
        Response response = Response.builder()
                .status(200)
                .message("Data not found").build();
        assertEquals(response, (Response) responseEntity.getBody());
    }

    @Test
    public void updateStatusWhenBookIsPresentTest(){
        String bookId = "Book123";
        String authorId = "Rishav11";
        boolean blockStatus = true;
        Product book = Product.builder().id(1).bookId("Book123").authorId("Rishav11").active(true).build();
        Mockito.when(bookRepository.findByBookIdAndAuthorId(bookId , authorId)).thenReturn(Optional.of(book));
        ResponseEntity responseEntity = bookService.updateStatus(blockStatus,authorId,bookId);
        String response1 = responseEntity.getStatusCode().toString();
        assertEquals("200 OK",response1);
    }

    @Test
    public void updateStatusWhenBookIsNotPresentTest(){
        String bookId = "Book123";
        String authorId = "Rishav11";
        boolean blockStatus = true;
        Product book = Product.builder().id(1).bookId("Book123").authorId("Rishav11").active(true).build();
        Mockito.when(bookRepository.findByBookIdAndAuthorId(bookId , authorId)).thenReturn(Optional.empty());
        ResponseEntity responseEntity = bookService.updateStatus(blockStatus,authorId,bookId);
        String response1 = responseEntity.getStatusCode().toString();
        assertEquals("200 OK",response1);
    }

    @Test
    public void getAllBooksWhenBookIsNotPresent(){
        List<Product> books = bookRepository.findAll();
        Mockito.when(bookRepository.findAll()).thenReturn(books);
        ResponseEntity responseEntity = bookService.getAllBooks();
        Object response = responseEntity.getBody();
        Response response1 = Response.builder()
                .status(200)
                .message("No Books found").build();
        assertEquals(response1,response);
    }

    @Test
    public void getAllBooksWhenBookIsPresent(){
        String authorId = "Rishav11";
        ProductSaveRequest bookSaveRequest = ProductSaveRequest.builder()
                .logo("abc")
                .author("Rishav")
                .price(100)
                .active(true)
                .publisher("XYZ")
                .publishedDate(LocalDateTime.now())
                .content("abc")
                .category("Funny")
                .title("Test").build();
        String category = "Funny";
        String title = "Toy Story";
        String author = "Rishav";
        int price = 600;
        String publisher = "XYZ";
        Product book = Product.builder().id(1).bookId("Book123").category("Funny").title("Toy Story").author("Rishav").price(600).publisher("XYZ").build();
        List<Product> booksList = new ArrayList<>();
        booksList.add(book);
        Object[] objects = new Object[booksList.size()];
        objects[0] = book;
        Mockito.when(bookRepository.findAll()).thenReturn(booksList);
        ResponseEntity responseEntity = bookService.getAllBooks();
        Object[] response = (Object[]) responseEntity.getBody();
    }

    @Test
    public void saveBookTest(){
        bookSaveRequest = ProductSaveRequest.builder()
                .logo("abc")
                .author("Rishav")
                .price(100)
                .active(true)
                .publisher("XYZ")
                .publishedDate(LocalDateTime.now())
                .content("abc")
                .category("Funny")
                .title("Test").build();
        String authorId = "abc";
        Product mockBook = Mockito.mock(Product.class);
        Mockito.lenient().when(bookRepository.save(any())).thenReturn(mockBook);
        Response response = Response.builder()
                .status(HttpStatus.OK.value())
                .message("Saved data successfully")
                .build();
        assertEquals(response,(Response) bookService.saveBook(bookSaveRequest,authorId).getBody());
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
