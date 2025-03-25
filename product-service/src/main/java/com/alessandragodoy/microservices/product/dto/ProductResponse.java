package com.alessandragodoy.microservices.product.dto;

import java.math.BigDecimal;

/**
 * A response DTO for a product.
 *
 * @param id the unique identifier of the product
 * @param name the name of the product
 * @param description the description of the product
 * @param price the price of the product
 */
public record ProductResponse(
		String id,
		String name,
		String description,
		BigDecimal price
) {
}
