package com.alessandragodoy.microservices.product.dto;

import java.math.BigDecimal;

/**
 * A request DTO for creating a product.
 *
 * @param id the unique identifier of the product
 * @param name the name of the product
 * @param description the description of the product
 * @param price the price of the product
 */
public record ProductRequest(
		String id,
		String name,
		String description,
		BigDecimal price
) {
}
