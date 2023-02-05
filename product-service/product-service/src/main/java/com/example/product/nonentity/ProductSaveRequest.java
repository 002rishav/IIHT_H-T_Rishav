package com.example.product.nonentity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Transient;

@Data
@Builder
public class ProductSaveRequest {
	
	private String name;
	
	private String description;
	
	private int price;
}
