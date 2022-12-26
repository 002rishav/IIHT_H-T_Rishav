package com.user.controller;

import com.user.output.BookResponse;
import com.user.output.SaveBookResponse;
import com.user.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final IBookService bookServiceImpl;

    @GetMapping(value="/search",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookResponse> searchBooks(@PathParam("category") String category, @PathParam("title") String title, @PathParam("author") String author, @PathParam("price") int price, @PathParam("publisher") String publisher) throws IOException {
        List<BookResponse> bookResponse;
        bookResponse=bookServiceImpl.fetchBooksByDetails(category, title, author, price, publisher);
        return bookResponse;
    }

    @GetMapping(value="/getAllBooks", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('Admin','User')")
    public Object getAllBooks(){
        return bookServiceImpl.getAllBooks();
    }

    @PostMapping(value="/updateStatus/{author-id}/{book-id}",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Admin')")
    public BookResponse updateActiveStatusOfBook(@PathVariable("author-id") String userName , @PathVariable("book-id") String bookId , @PathParam("block") boolean active){
        return bookServiceImpl.updateStatus(active , userName , bookId);
    }

    @PostMapping(value="/save/{author-id}",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity postEndpointToSaveData(@RequestBody SaveBookResponse saveBookResponse, @PathVariable("author-id") String userName){
        return bookServiceImpl.saveBook(saveBookResponse , userName);
    }

    @PutMapping(value="/update/{author-id}/{book-id}",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity putEndpointToUpdateData(@RequestBody SaveBookResponse saveBookResponse, @PathVariable("author-id") String userName, @PathVariable("book-id") String bookId){
        return bookServiceImpl.updateBook(saveBookResponse , userName, bookId);
    }
}
