package com.user.service;

import com.user.output.BookResponse;
import com.user.output.SaveBookResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    public List<BookResponse> fetchBooksByDetails(String category, String title, String author, int price, String publisher);

    public Boolean activeStatus(String bookId);

    Object getBookContent(String bookId);

    public String getBookById(String bookId);

    public Object getAllBooks();

    public BookResponse updateStatus(boolean active, String userName, String bookId);

    public ResponseEntity saveBook(SaveBookResponse saveBookResponse, String userName);

    public ResponseEntity updateBook(SaveBookResponse saveBookResponse, String userName, String bookId);
}
