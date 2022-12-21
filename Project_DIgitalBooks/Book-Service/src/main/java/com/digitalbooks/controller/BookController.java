package com.digitalbooks.controller;

import com.digitalbooks.nonentity.BookSaveRequest;
import com.digitalbooks.service.IBookService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
public class BookController {

	@Autowired
    private final IBookService bookService;

    @GetMapping("/api/v1/digitalbooks/search")
    public ResponseEntity getEndpointToSearchData(@PathParam("category") String category,@PathParam("title") String title,@PathParam("author") String author,@PathParam("price") int price,@PathParam("publisher") String publisher){
        return bookService.searchBook(category,title,author,price,publisher);
    }

    @PostMapping("/api/v1/digitalbooks/author/{author-id}/books")
    public ResponseEntity postEndpointToSaveData(@PathVariable("author-id") String authorId , @RequestBody BookSaveRequest bookSaveRequest){
        return bookService.saveBook(bookSaveRequest , authorId);
    }

    @PostMapping("/api/v1/digitalbooks/author/{author-id}/books/{book-id}")
    public ResponseEntity updateActiveStatusOfBook(@PathVariable("author-id") String authorId , @PathVariable("book-id") String bookId , @PathParam("block") boolean block){
        return bookService.updateStatus(block , authorId , bookId);
    }

    @PutMapping("/api/v1/digitalbooks/author/{author-id}/books/{book-id}")
    public ResponseEntity putEndpointToSaveData(@PathVariable("author-id") String authorId , @RequestBody BookSaveRequest bookSaveRequest , @PathVariable("book-id") String bookId){
        return bookService.updateBookEntity(bookSaveRequest , authorId , bookId);
    }
}

