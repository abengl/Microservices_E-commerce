package com.alessandragodoy.microservices.product.service;

import com.alessandragodoy.microservices.product.dto.ProductRequest;
import com.alessandragodoy.microservices.product.dto.ProductResponse;
import com.alessandragodoy.microservices.product.model.Product;
import com.alessandragodoy.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing products.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	private final ProductRepository productRepository;

	/**
	 * Creates a new product.
	 *
	 * @param productRequest the request object containing product details
	 * @return the response object containing created product details
	 */
	public ProductResponse createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.name(productRequest.name())
				.description(productRequest.description())
				.price(productRequest.price())
				.build();

		productRepository.save(product);
		log.info("Product created successfully.");
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

	/**
	 * Retrieves all products.
	 *
	 * @return a list of response objects containing product details
	 */
	public List<ProductResponse> getAllProducts() {
		return productRepository.findAll()
				.stream()
				.map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(),
						product.getPrice()))
				.collect(Collectors.toList());
	}
}
