package br.com.systec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systec.exeptions.ResouceNotFoundException;
import br.com.systec.model.Person;
import br.com.systec.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {
		logger.info("Find all people!");

		
		return repository.findAll();
	}

	public Person findById(Long id) {
		logger.info("Find one person!");

		return repository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
		// .orElseThrow(() -> new ResourceNotFoundException("No records found for this
		// ID"));
	}

	public Person create(Person person) {

		logger.info("Create one person!");

		return repository.save(person);
	}

	public Person update(Person person) {
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(person);
	}

	public void delete(Long id) {

		logger.info("Delete one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

	
}