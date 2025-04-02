package com.microserviceapp.cicd_atcions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class CicdAtcionsApplication {

	@GetMapping(    "/greet")
	public Map<String, String> greetUser() {
		Map<String, String> response = new HashMap<>();
		response.put("message", "Hello Threading clouds, have a nice day!!!!!!)");
		response.put("timestamp", LocalDateTime.now().toString());
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(CicdAtcionsApplication.class, args);
	}

}
