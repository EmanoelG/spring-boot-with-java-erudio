package br.com.emanoel.habilidades.services;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

import br.com.emanoel.habilidades.models.Person;


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
	
	public List<Person> findAll() {
		logger.info("FindAll one person !");		
		List<Person> persons = new ArrayList<Person>();
		for(int i=0; i<8; i++) {
			persons.add( mockPerson(i));
			}
		return persons;
	 }
	
	 private Person mockPerson(int i) {
		 Person person = new Person();
			person.setId(counter.incrementAndGet());
			person.setFirstName("Emanoel "+i);
			person.setLastName("Galvão ");
			person.setAddress("Clevelândia -PR");
			person.setGender("Male"); 
			return person;
	 }
	 
	 public Person create(Person person) {
		 logger.info("findCreate  person !");	
		 Person personS = new Person();
		 personS = person;
		 return personS;
	 }
	 
	 public void delete(String ud) {
		 logger.info("Delete  person !");	
//		 Person personS = new Person();
//		 personS = person;
//		 return personS;
	 }

}
