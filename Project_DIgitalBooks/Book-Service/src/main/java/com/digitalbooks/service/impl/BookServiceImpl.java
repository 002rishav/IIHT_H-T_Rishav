package com.digitalbooks.service.impl;

import com.digitalbooks.entity.Book;
import com.digitalbooks.enums.ErrorCodes;
import com.digitalbooks.exception.GlobalException;
import com.digitalbooks.nonentity.BookSaveRequest;
import com.digitalbooks.nonentity.Response;
import com.digitalbooks.repository.IBookRepository;
import com.digitalbooks.service.IBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements IBookService {

	@Autowired
    private static IBookRepository bookRepository ;

    private static final String BOOK_SAVED_SUCCESSFULLY = "Saved data successfully";

    private static final String BOOK_ID_PREFIX = "Book";

    @Override
    public ResponseEntity saveBook(BookSaveRequest bookSaveRequest, String authorId) {
        try{
            Book books = Book.builder()
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
        catch (Exception ex)
        {
            log.info("Error saving data into database");
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }

    @Override
    public ResponseEntity updateStatus(boolean blockStatus, String authorId, String bookId) {

       Optional<Book> optionalBooks = bookRepository.findByBookIdAndAuthorId(bookId , authorId);

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
           Book books = optionalBooks.get();
           books.setActive(blockStatus);
           return ResponseEntity.ok(bookRepository.save(books));
       }
       catch (Exception exception)
       {
           log.info("Error saving data into database");
           throw new GlobalException(ErrorCodes.BOOK_EXP_001);
       }
    }

    @Override
    public ResponseEntity updateBookEntity(BookSaveRequest bookSaveRequest, String authorId, String bookId) {
        Optional<Book> optionalBooks = bookRepository.findByBookIdAndAuthorId(bookId , authorId);

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
            Book books = optionalBooks.get();
            updateBooksEntity(bookSaveRequest, books);
            return ResponseEntity.ok(bookRepository.save(books));
        }
        catch (Exception exception)
        {
            log.info("Error saving data into database");
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }
    private static void updateBooksEntity(BookSaveRequest bookSaveRequest, Book books) {
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
        Optional<Book> optionalBooks = bookRepository.findByCategoryOrTitleOrAuthorOrPriceOrPublisher(category , title,author,price,publisher);

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
            Book books = optionalBooks.get();
            return ResponseEntity.ok(optionalBooks);
        }
        catch (Exception exception)
        {
            log.info("Error saving data into database");
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }
}


