package com.alessandragodoy.microservices.product.controller;

import com.alessandragodoy.microservices.product.dto.ProductRequest;
import com.alessandragodoy.microservices.product.dto.ProductResponse;
import com.alessandragodoy.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing products.
 * Provides endpoints for creating and retrieving products.
 */
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	/**
	 * Creates a new product.
	 *
	 * @param productRequest the product request containing product details
	 * @return the created product response
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
		return productService.createProduct(productRequest);
	}

	/**
	 * Retrieves all products.
	 *
	 * @return a list of product responses
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}
}
