package com.project.Person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Person.model.Person;
import com.project.Person.service.PersonServiceImpl;

@RestController
public class PersonController {
	@Autowired
	private PersonServiceImpl service;
	
	@GetMapping("/person")
	public Person getPerson(@RequestParam(name="id")Long id) {
		return service.getPersonById(id);
	}

	@PostMapping("/person/new")
	public String createPerson(Person person) {
		service.savePerson(person);
		return "Person created!";
	}
}
