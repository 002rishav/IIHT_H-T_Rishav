package com.example.book.service;

import com.example.book.nonentity.BookSaveRequest;
import org.springframework.http.ResponseEntity;

public interface BookService {

    public ResponseEntity saveBook(BookSaveRequest bookSaveRequest, String authorId);

    public ResponseEntity updateStatus(boolean blockStatus , String authorId, String bookId);

    public ResponseEntity updateBookEntity(BookSaveRequest bookSaveRequest , String authorId , String bookId);

    public ResponseEntity searchBook(String category, String title, String author, int price, String publisher);

    public ResponseEntity activeStatus(String bookId);

    public ResponseEntity getBookContent(String bookId);

    public ResponseEntity getBookByBookId(String bookId);

    public ResponseEntity<Object> getAllBooks();
}
