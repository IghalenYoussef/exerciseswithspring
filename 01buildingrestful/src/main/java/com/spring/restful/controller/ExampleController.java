package com.spring.restful.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restful.model.Example;

@RestController
public class ExampleController {
	
	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	
	@GetMapping("/example")
	public Example example(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Example(counter.incrementAndGet(), String.format(template, name));
	}

}
