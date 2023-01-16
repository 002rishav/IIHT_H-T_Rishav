package com.example.product.nonentity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductSaveRequest {

	private String name;
	
	private String description;
	
	private int price;
}
