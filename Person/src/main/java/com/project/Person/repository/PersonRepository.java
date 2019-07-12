package com.project.Person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	public Person findPersonById(Long id);
	public Person findPersonByName(String name);
	public List<Person> findPersonByAge(Integer age);
}
