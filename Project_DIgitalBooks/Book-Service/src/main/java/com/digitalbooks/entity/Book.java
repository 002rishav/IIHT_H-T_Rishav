package com.digitalbooks.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "books" , uniqueConstraints = @UniqueConstraint(columnNames = "book_id"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "book_id" , nullable = false)
    private String bookId ;

    @Column(name = "author_id")
    private String authorId ;

    @Column(name = "author")
    private String author ;

    @Column(name = "logo")
    private String logo ;

    @Column(name = "title")
    private String title ;

    @Column(name = "category")
    private String category ;

    @Column(name = "price")
    private int price ;

    @Column(name = "publisher")
    private String publisher ;

    @Column(name = "published_date")
    private LocalDateTime publishedDate ;

    @Column(name = "content")
    private String content ;

    @Column(name = "active")
    private boolean active ;

}
