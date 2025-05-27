package com.example.LokiDemoApplication;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LokiDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(LokiDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LokiDemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		logger.info("Hello from Spring Boot - this is an info log");
		logger.warn("This is a warning log");
		try {
			double result = 1/0;
			double result2 = result + 5;
		} catch (Exception e) {
			logger.error("custom logger: ", e);
		}
		logger.error("This is an error log");
	}

}
