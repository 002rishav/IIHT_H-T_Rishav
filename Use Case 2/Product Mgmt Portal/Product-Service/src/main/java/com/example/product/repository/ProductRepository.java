package com.example.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.product.entity.Product;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product , Integer> {

//    Optional<Product> findByBookIdAndAuthorId(String bookId , String authorId);
//
//    Optional<List<Product>> findByCategoryOrTitleOrAuthorOrPriceOrPublisher(String category, String tittle, String author, int price, String publisher);

    Optional<Product> findByName(String name);
}
