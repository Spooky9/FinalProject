package com.project.Person;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.Person.model.Person;
import com.project.Person.repository.PersonRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

	private Person person1;
	private Person person2;
	private Person person3;
	
	@Autowired
	private PersonRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Before
	public void setUp() {
		person1 = new Person("Bob", 20);
		person2 = new Person("Jane", 25);
		person3 = new Person("Craig", 40);
		entityManager.persistAndFlush(person1);
		entityManager.persistAndFlush(person2);
		entityManager.persistAndFlush(person3);
	}
	
	@Test
	public void findById_shouldReturnCorrectPerson() {
		Person foundPerson = repo.findPersonById(person1.getId());
		assertEquals(person1, foundPerson);
	}

}
