package com.example.product.service;

import org.springframework.http.ResponseEntity;

import com.example.product.nonentity.ProductSaveRequest;

public interface ProductService {

    public ResponseEntity saveBook(ProductSaveRequest bookSaveRequest, String authorId);

    public ResponseEntity updateStatus(boolean blockStatus , String authorId, String bookId);

    public ResponseEntity updateBookEntity(ProductSaveRequest bookSaveRequest , String authorId , String bookId);

    public ResponseEntity searchBook(String category, String title, String author, int price, String publisher);

    public ResponseEntity activeStatus(String bookId);

    public ResponseEntity getBookContent(String bookId);

    public ResponseEntity getBookByBookId(String bookId);

    public ResponseEntity<Object> getAllBooks();
}
