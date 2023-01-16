package com.example.product.controller;

import com.example.product.nonentity.ProductSaveRequest;
import com.example.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService bookService ;

    @GetMapping("/api/v1/digitalbooks/search")
    public ResponseEntity getEndpointToSearchData(@PathParam("category") String category,@PathParam("title") String title,@PathParam("author") String author,@PathParam("price") int price,@PathParam("publisher") String publisher){
        return bookService.searchBook(category,title,author,price,publisher);
    }

    @GetMapping("/api/v1/digitalbooks/getAllBooks")
    public ResponseEntity<Object> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/api/v1/digitalbooks/getActiveStatus/{book-id}")
    public ResponseEntity getActiveStatusOfBook(@PathVariable("book-id") String bookId){
        return bookService.activeStatus(bookId);
    }

    @GetMapping("/api/v1/digitalbooks/getBookContent/{book-id}")
    public ResponseEntity getBookContent(@PathVariable("book-id") String bookId){
        return bookService.getBookContent(bookId);
    }

    @GetMapping("/api/v1/digitalbooks/getBook/{book-id}")
    public ResponseEntity getBookById(@PathVariable("book-id") String bookId){
        return bookService.getBookByBookId(bookId);
    }

    @PostMapping("/api/v1/digitalbooks/author/{author-id}/books")
    public ResponseEntity postEndpointToSaveData(@PathVariable("author-id") String authorId , @RequestBody ProductSaveRequest bookSaveRequest){
        return bookService.saveBook(bookSaveRequest , authorId);
    }

    @PostMapping("/api/v1/digitalbooks/author/{author-id}/books/{book-id}")
    public ResponseEntity updateActiveStatusOfBook(@PathVariable("author-id") String authorId , @PathVariable("book-id") String bookId , @RequestParam("block") boolean block){
        return bookService.updateStatus(block , authorId , bookId);
    }

    @PutMapping("/api/v1/digitalbooks/author/{author-id}/books/{book-id}")
    public ResponseEntity putEndpointToSaveData(@PathVariable("author-id") String authorId , @RequestBody ProductSaveRequest bookSaveRequest , @PathVariable("book-id") String bookId){
        return bookService.updateBookEntity(bookSaveRequest , authorId , bookId);
    }
}
