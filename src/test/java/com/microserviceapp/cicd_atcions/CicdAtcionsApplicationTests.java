package com.microserviceapp.cicd_atcions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CicdAtcionsApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testGreetEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity("/greet", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotEmpty();
	}
}
