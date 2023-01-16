package com.user.output;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Integer price;

    private String name;

    private String description;

}
