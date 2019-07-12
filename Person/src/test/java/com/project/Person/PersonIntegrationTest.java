package com.project.Person;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.project.Person.model.Person;
import com.project.Person.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment=WebEnvironment.MOCK, 
		classes=PersonApplication.class
		)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-integrationtest.properties")
public class PersonIntegrationTest {

	private Person person1;
	
	@Autowired
	private PersonRepository repo;
	
	@Autowired
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		person1 = new Person("Bob", 20);
		repo.save(person1);
	}

	@After
	public void tearDown() throws Exception {
		repo.deleteAll();
	}

	@Test
	public void givenId_getPerson_returnsPerson() throws Exception{
		Long personId = person1.getId();
		
		mvc.perform(get("/person?id=" + personId)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(personId));

	}
}
