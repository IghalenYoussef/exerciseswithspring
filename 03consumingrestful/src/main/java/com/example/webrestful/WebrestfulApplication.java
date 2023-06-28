package com.example.webrestful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.webrestful.model.Example;

@SpringBootApplication
public class WebrestfulApplication {
	
	private static final Logger log = LoggerFactory.getLogger(WebrestfulApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebrestfulApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Example example = restTemplate.getForObject(
					"http://localhost:8080/api/random", Example.class);
			log.info(example.toString());
		};
	}

}
