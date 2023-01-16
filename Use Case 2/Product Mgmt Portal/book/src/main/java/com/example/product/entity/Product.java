package com.example.product.entity;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {
	
	@Id
	private String name;
	private String description;
	private int price;
	
}
