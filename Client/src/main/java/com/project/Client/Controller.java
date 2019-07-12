package com.project.Client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

	@GetMapping("/")
	public void get(){
        RestTemplate restTemplate = new RestTemplate();
		Map<?,?> quote = restTemplate.getForObject("http://localhost:8080/person?id=1", HashMap.class);
        System.out.println(quote.get("name"));
	}
	
	@PostMapping("/")
	public void create(){
        RestTemplate restTemplate = new RestTemplate();
		Map<?,?> quote = restTemplate.getForObject("http://localhost:8080/person/new", HashMap.class);
        System.out.println(quote.post("name"));
	}
}
