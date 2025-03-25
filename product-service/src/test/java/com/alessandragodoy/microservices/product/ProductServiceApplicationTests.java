package com.alessandragodoy.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;


/**
 * Test class for the ProductServiceApplication.
 * Uses Testcontainers to manage a MongoDB instance for integration tests.
 */
@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Indicate that this is a Spring Boot test class with a random web environment port
class ProductServiceApplicationTests {

	// Define a static MongoDBContainer instance with the specified MongoDB version
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	// Static block to start the MongoDB container before any tests are run
	static {
		mongoDBContainer.start();
	}

	// Inject the local server port used by the Spring Boot application
	@LocalServerPort
	private Integer port;

	/**
	 * Set up method to configure RestAssured before each test.
	 */
	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	/**
	 * Test to verify that a product can be created successfully.
	 */
	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
					"name": "Iphone 15",
				    "description": "Latest smartphone from apple",
				    "price": 1000
				}
				""";

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("Iphone 15"))
				.body("description", Matchers.equalTo("Latest smartphone from apple"))
				.body("price", Matchers.equalTo(1000));
	}
}


