package com.alessandragodoy.microservices.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Represents a product entity.
 * This class is mapped to the "product" collection in MongoDB.
 */
@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;

}
