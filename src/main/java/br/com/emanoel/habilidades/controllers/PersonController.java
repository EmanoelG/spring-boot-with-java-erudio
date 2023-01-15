package br.com.emanoel.habilidades.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emanoel.habilidades.model.Person;
import br.com.emanoel.habilidades.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	 @Autowired
	    private PersonServices service;

	    @GetMapping(value="/{id}",
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public Person findById(@PathVariable("id") String id) throws Exception {
	        return service.findById(id);
	    }
	
   
}