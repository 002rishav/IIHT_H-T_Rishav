package com.user.output;

import lombok.*;
import java.time.LocalDateTime;

import com.user.constraints.ProductConstraint;

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

