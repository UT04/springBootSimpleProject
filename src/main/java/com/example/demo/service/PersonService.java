package com.example.demo.service;

import com.example.demo.dto.PersonRequestDto;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

	private PersonRepository personRepository;

	private final PersonMapper personMapper; // Injektion des Mappers

	public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
		this.personRepository = personRepository;
		this.personMapper = personMapper;

	}

	public List<Person> getAllPersons() {
		return personRepository.findAll().stream().filter(person -> person.getId().equals(1)).toList();
	}
	
	public List<Person> getAllPersonsAlternative() {
		return personRepository.findAll().stream().filter(person -> person.getId().equals(1)).toList();
	}

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public Optional<Person> getPersonById(Long id) {
		return personRepository.findById(id);
	}

	public Person createPerson(PersonRequestDto requestDto) {
		// Automatische Abbildung vom DTO zur Entity
		Person person = personMapper.personRequestDtoToPerson(requestDto);
		return personRepository.save(person);
	}

	public Optional<Person> updatePerson(Long id, PersonRequestDto requestDto) {
		return personRepository.findById(id).map(existingPerson -> {
			// Da mapstruct standardmäßig keine "partial updates" macht, ist es oft
			// sicherer, die Werte manuell zu setzen oder einen "update"-Method zu
			// definieren.
			// Für dieses Beispiel nutzen wir die manuelle Zuordnung für die Sicherheit, da
			// MapStruct standardmäßig nur neue Instanzen erstellt:
			existingPerson.setName(requestDto.getName());
			existingPerson.setEmail(requestDto.getEmail());
			return personRepository.save(existingPerson);
		});
	}

	public boolean deletePerson(Long id) {
		if (personRepository.existsById(id)) {
			personRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
