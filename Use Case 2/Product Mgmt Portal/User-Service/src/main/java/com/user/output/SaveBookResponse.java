package com.user.output;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveBookResponse {

    private String author;

    private String logo;

    private String title;

    private String category;

    private Integer price;

    private String publisher;

    private LocalDateTime publishedDate;

    private String content;

    private Boolean active;

}

