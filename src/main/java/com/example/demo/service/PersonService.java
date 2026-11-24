package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

	
    //@Autowired
    private PersonRepository personRepository;

    public PersonService (PersonRepository personRepository) {
    	this.personRepository = personRepository;
    	
    }
    
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
   
    public Optional<Person> getPerson(Long id) {
    	Optional<Person> optPerson = personRepository.findById(id);
    	
    	return optPerson;
    }
   
    
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
