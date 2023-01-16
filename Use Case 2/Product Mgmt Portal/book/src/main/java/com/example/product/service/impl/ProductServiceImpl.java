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

    private final ProductRepository bookRepository ;

    private static final String BOOK_SAVED_SUCCESSFULLY = "Saved data successfully";

    private static final String BOOK_ID_PREFIX = "Book";

    @Override
    public ResponseEntity saveBook(ProductSaveRequest bookSaveRequest, String authorId) {
        try{
            Product books = Product.builder()
                    .logo(bookSaveRequest.getLogo())
                    .publisher(bookSaveRequest.getPublisher())
                    .publishedDate(bookSaveRequest.getPublishedDate())
                    .price(bookSaveRequest.getPrice())
                    .title(bookSaveRequest.getTitle())
                    .author(bookSaveRequest.getAuthor())
                    .active(bookSaveRequest.isActive())
                    .content(bookSaveRequest.getContent())
                    .category(bookSaveRequest.getCategory())
                    .authorId(authorId)
                    .bookId(BOOK_ID_PREFIX+ UUID.randomUUID().toString().substring(0 , 10))
                    .build();

            log.info("Saving data for authorId :{}" , authorId);
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(() -> {
                bookRepository.save(books);
            });
            Response response = Response.builder()
                    .status(HttpStatus.OK.value())
                    .message(BOOK_SAVED_SUCCESSFULLY)
                    .build();
            return ResponseEntity.ok(response);
        }
        catch (RuntimeException ex)
        {
            log.info("Error saving data into database");
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }
    @Override
    public ResponseEntity updateStatus(boolean blockStatus, String authorId, String bookId) {

       Optional<Product> optionalBooks = bookRepository.findByBookIdAndAuthorId(bookId , authorId);

       Response response ;
       if(!optionalBooks.isPresent())
       {
           log.info("Empty books entity found");
           response = Response.builder()
                   .status(200)
                   .message("Data not found").build();
           return ResponseEntity.ok(response);
       }
           Product books = optionalBooks.get();
           books.setActive(blockStatus);
           return ResponseEntity.ok(bookRepository.save(books));
    }
    @Override
    public ResponseEntity updateBookEntity(ProductSaveRequest bookSaveRequest, String authorId, String bookId) {
        Optional<Product> optionalBooks = bookRepository.findByBookIdAndAuthorId(bookId , authorId);

        Response response ;
        if(!optionalBooks.isPresent())
        {
            log.info("Empty books entity found");
            response = Response.builder()
                    .status(200)
                    .message("Data not found").build();
            return ResponseEntity.ok(response);
        }
        try {
            Product books = optionalBooks.get();
            updateBooksEntity(bookSaveRequest, books);
            return ResponseEntity.ok(bookRepository.save(books));
        }
        catch (Exception exception)
        {
            log.info("Error saving data into database");
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }
    private static void updateBooksEntity(ProductSaveRequest bookSaveRequest, Product books) {
        books.setLogo(bookSaveRequest.getLogo());
        books.setTitle(bookSaveRequest.getTitle());
        books.setCategory(bookSaveRequest.getCategory());
        books.setPrice(bookSaveRequest.getPrice());
        books.setAuthor(bookSaveRequest.getAuthor());
        books.setPublisher(bookSaveRequest.getPublisher());
        books.setPublishedDate(bookSaveRequest.getPublishedDate());
        books.setContent(bookSaveRequest.getContent());
        books.setActive(bookSaveRequest.isActive());
    }
    @Override
    public ResponseEntity searchBook(String category, String title, String author, int price, String publisher) {
        Optional<List<Product>> optionalBooks = bookRepository.findByCategoryOrTitleOrAuthorOrPriceOrPublisher(category,title,author,price,publisher);

        Response response ;
        if(!optionalBooks.isPresent())
        {
            log.info("Empty books entity found");
            response = Response.builder()
                    .status(200)
                    .message("Data not found").build();
            return ResponseEntity.ok(response);
        }
        try {
            return ResponseEntity.ok(optionalBooks);
        }
        catch (Exception exception)
        {
            log.info("Error finding data into database",exception.getMessage());
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }
    @Override
    public ResponseEntity activeStatus(String bookId) {
        Optional<Product> optionalBooks = bookRepository.findByBookId(bookId);

        Response response ;
        if(!optionalBooks.isPresent())
        {
            log.info("Empty books entity found");
            response = Response.builder()
                    .status(200)
                    .message("Data not found").build();
            return ResponseEntity.ok(response);
        }
        Product books = optionalBooks.get();
        return ResponseEntity.ok(books.isActive());
    }
    @Override
    public ResponseEntity getBookContent(String bookId) {
        Optional<Product> optionalBooks = bookRepository.findByBookId(bookId);

        Response response ;
        if(!optionalBooks.isPresent())
        {
            log.info("Empty books entity found");
            response = Response.builder()
                    .status(200)
                    .message("Data not found").build();
            return ResponseEntity.ok(response);
        }
        Product books = optionalBooks.get();
        return ResponseEntity.ok(books);
    }
    @Override
    public ResponseEntity getBookByBookId(String bookId){
        Optional<Product> optionalBooks = bookRepository.findByBookId(bookId);
        Response response ;
        if(!optionalBooks.isPresent())
        {
            log.info("Empty books entity found");
            response = Response.builder()
                    .status(200)
                    .message("Data not found").build();
            return ResponseEntity.ok(response);
        }
        Product books = optionalBooks.get();
        return ResponseEntity.ok(books.getBookId());
    }
    @Override
    public ResponseEntity<Object> getAllBooks(){
        Object[] optionalBooks = bookRepository.findAll().toArray();
        Response response ;
        if(optionalBooks.length == 0)
        {
            log.info("No books found");
            response = Response.builder()
                    .status(200)
                    .message("No Books found").build();
            return ResponseEntity.ok(response);
        }
        try {
            return ResponseEntity.ok(optionalBooks);
        }
        catch (Exception exception)
        {
            log.info("Error finding data into database");
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }
}
