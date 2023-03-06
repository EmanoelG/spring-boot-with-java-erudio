package br.com.emanoel.habilidades.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emanoel.habilidades.PersonRepositories.PersonRespository;
import br.com.emanoel.habilidades.exceptions.ResourceNotFoundException;
import br.com.emanoel.habilidades.models.Person;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRespository repository;

	public Person findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id !"));
	}

	public List<Person> findAll() {
		logger.info("FindAll one person !");

		return repository.findAll();
	}

	public Person create(Person person) {
		logger.info("Create one person !");

		return repository.save(person);
	}

	public Person update(Person person) {
		logger.info("update  person !");

		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return entity;
	}

	public void delete(Long id) {
		logger.info("Delete  person !");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));
		repository.delete(entity);
	}

}
