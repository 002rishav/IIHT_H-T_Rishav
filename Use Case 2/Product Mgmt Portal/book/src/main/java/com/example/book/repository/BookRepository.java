package com.example.book.repository;

import com.example.book.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books , Integer> {

    Optional<Books> findByBookIdAndAuthorId(String bookId , String authorId);

    Optional<List<Books>> findByCategoryOrTitleOrAuthorOrPriceOrPublisher(String category, String tittle, String author, int price, String publisher);

    Optional<Books> findByBookId(String bookId);
}
