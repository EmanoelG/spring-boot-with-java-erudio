package br.com.emanoel.habilidades.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emanoel.habilidades.PersonRepositories.PersonRespository;
import br.com.emanoel.habilidades.exceptions.ResourceNotFoundException;
import br.com.emanoel.habilidades.models.PersonVO;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRespository repository;

	public PersonVO findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id !"));
	}

	public List<PersonVO> findAll() {
		logger.info("FindAll one PersonVO !");

		return repository.findAll();
	}

	public PersonVO create(PersonVO PersonVO) {
		logger.info("Create one PersonVO !");

		return repository.save(PersonVO);
	}

	public PersonVO update(PersonVO PersonVO) {
		logger.info("update  PersonVO !");

		var entity = repository.findById(PersonVO.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));
		entity.setLastName(PersonVO.getLastName());
		entity.setAddress(PersonVO.getAddress());
		entity.setGender(PersonVO.getGender());
		return entity;
	}

	public void delete(Long id) {
		logger.info("Delete  PersonVO !");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));
		repository.delete(entity);
	}

}
