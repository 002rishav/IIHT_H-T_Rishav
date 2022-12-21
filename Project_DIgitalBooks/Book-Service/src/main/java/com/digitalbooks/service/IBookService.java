package com.digitalbooks.service;

import com.digitalbooks.nonentity.BookSaveRequest;
import org.springframework.http.ResponseEntity;

public interface IBookService {

    public ResponseEntity saveBook(BookSaveRequest bookSaveRequest, String authorId);

    public ResponseEntity updateStatus(boolean blockStatus , String authorId, String bookId);

    public ResponseEntity updateBookEntity(BookSaveRequest bookSaveRequest , String authorId , String bookId);

    public ResponseEntity searchBook(String category, String title, String author, int price, String publisher);
}