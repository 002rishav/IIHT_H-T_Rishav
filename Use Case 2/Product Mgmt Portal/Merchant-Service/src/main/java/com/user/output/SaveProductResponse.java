package com.user.output;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveProductResponse {

    private Integer price;

    private String name;

    private String description;

}

