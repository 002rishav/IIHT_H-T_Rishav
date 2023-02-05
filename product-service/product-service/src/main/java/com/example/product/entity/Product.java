package com.example.product.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {	
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
    private int id ;
	
	private String name;
	
	private String description;
	
	private int price;
	
}
