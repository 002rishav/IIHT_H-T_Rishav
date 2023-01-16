package com.example.product.nonentity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductSaveRequest {

    private String logo ;

    private String title ;

    private String category ;

    private int price ;

    private String author ;

    private String publisher ;

    private LocalDateTime publishedDate ;

    private String content ;

    private boolean active ;
}
