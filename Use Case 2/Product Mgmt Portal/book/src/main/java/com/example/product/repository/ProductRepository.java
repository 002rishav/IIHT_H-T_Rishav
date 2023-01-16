package com.example.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer> {

    Optional<Product> findByBookIdAndAuthorId(String bookId , String authorId);

    Optional<List<Product>> findByCategoryOrTitleOrAuthorOrPriceOrPublisher(String category, String tittle, String author, int price, String publisher);

    Optional<Product> findByBookId(String bookId);
}
