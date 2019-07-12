package com.project.Person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Person.model.Person;
import com.project.Person.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonServiceInt{

	@Autowired
	private PersonRepository repo;
	
	@Override
	public Person getPersonByName(String name) {
		return repo.findPersonByName(name);
	}

	@Override
	public Person getPersonById(Long id) {
		return repo.findPersonById(id);
	}

	@Override
	public List<Person> getPersonByAge(Integer age) {
		return repo.findPersonByAge(age);
	}

	@Override
	public void savePerson(Person person) {
		repo.save(person);
	}

	
}
