package br.com.emanoel.habilidades.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

import br.com.emanoel.habilidades.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		
		logger.info("Find one person !");		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Emanoel ");
		person.setLastName("Galvão ");
		person.setAddress("Clevelândia -PR");
		person.setGender("Male");
		return person;
	}
}