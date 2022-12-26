package com.user.output;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private Integer id;

    private String bookId;

    private String authorId;

    private String author;

    private String logo;

    private String title;

    private String category;

    private Integer price;

    private String publisher;

    private Date publishedDate;

    private String content;

    private Boolean active;

}
