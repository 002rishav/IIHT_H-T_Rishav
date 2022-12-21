package com.digitalbooks.repository;

import com.digitalbooks.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBookRepository extends JpaRepository<Book , Integer> {

    Optional<Book> findByBookIdAndAuthorId(String bookId , String authorId);

    Optional<Book> findByCategoryOrTitleOrAuthorOrPriceOrPublisher(String category,String tittle,String author,int price,String publisher);
}