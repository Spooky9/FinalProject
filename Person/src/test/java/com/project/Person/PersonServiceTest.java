package com.project.Person;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.Person.model.Person;
import com.project.Person.repository.PersonRepository;
import com.project.Person.service.PersonServiceImpl;
import com.project.Person.service.PersonServiceInt;

@RunWith(SpringRunner.class)
public class PersonServiceTest {

	@TestConfiguration
	static class PersonConfiguration {
		@Bean
		public PersonServiceInt personService()
		{
			return new PersonServiceImpl();
		}
	}
	@Autowired
	PersonServiceInt service;
	
	@MockBean
	PersonRepository repo;
	
	@Before
	public void setUp() throws Exception {
		Person person1 = new Person("Bob", 20);
		Mockito.when(repo.findPersonByName(person1.getName())).thenReturn(person1);
	}

	@Test
	public void whenGivenName_thenReturnMatchingPerson() {
		String name = "Bob";
		Person found = service.getPersonByName(name);
		
		assertEquals(name, found.getName());
	}

}
