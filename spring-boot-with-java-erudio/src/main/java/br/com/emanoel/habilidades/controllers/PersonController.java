package br.com.emanoel.habilidades.controllers;
import java.net.Authenticator.RequestorType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.emanoel.habilidades.models.Person;
import br.com.emanoel.habilidades.services.PersonServices;

@RestController
@RequestMapping("/persons")
public class PersonController {

	    @Autowired
	    private PersonServices service;

	    @RequestMapping(value="/{id}",
	    		method =RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public Person findById(@PathVariable("id") String id) throws Exception {
	        return service.findById(id);
	    }
	    
	    @RequestMapping(
	    		value="/all",
	    		method =RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Person> findAll() throws Exception {
	        return service.findAll();
	    }
	    
	   
	
   
}