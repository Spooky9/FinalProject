package com.project.Person.service;

import java.util.List;

import com.project.Person.model.Person;

public interface PersonServiceInt {

	public Person getPersonByName(String name);
	public Person getPersonById(Long id);
	public List<Person> getPersonByAge(Integer age);
	public void savePerson(Person person);
}
