package com.alessandragodoy.microservices.product.repository;

import com.alessandragodoy.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for managing `Product` entities in MongoDB.
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
