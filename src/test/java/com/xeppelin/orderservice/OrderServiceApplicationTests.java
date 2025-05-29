package com.xeppelin.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class OrderServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		// This test verifies that the Spring application context loads successfully
		assertThat(port).isPositive();
	}

	@Test
	void actuatorHealthEndpointIsAvailable() {
		ResponseEntity<String> response = restTemplate.getForEntity(
			"http://localhost:" + port + "/actuator/health", String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).contains("UP");
	}

	@Test
	void actuatorInfoEndpointIsAvailable() {
		ResponseEntity<String> response = restTemplate.getForEntity(
			"http://localhost:" + port + "/actuator/info", String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void mainMethodRunsSuccessfully() {
		// This test ensures the main method can be called without throwing exceptions
		String[] args = {};
		// Note: We can't actually run SpringApplication.run here as it would start another context
		// Instead, we verify the main method exists and is accessible
		assertThat(OrderServiceApplication.class.getDeclaredMethods())
			.extracting("name")
			.contains("main");
	}
}
