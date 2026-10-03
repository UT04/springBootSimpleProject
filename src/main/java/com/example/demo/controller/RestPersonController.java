package com.example.demo.controller;

import com.example.demo.dto.PersonRequestDto;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@CrossOrigin(origins = "*") // Erlaubt Zugriffe von deiner Frontend-App (z.B. Angular/React)
public class RestPersonController {

    private final PersonService personService;

    public RestPersonController(PersonService personService) {
        this.personService = personService;
    }

    // GET /api/v1/persons
    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    // GET /api/v1/persons/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/v1/persons
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody PersonRequestDto requestDto) {
        Person createdPerson = personService.createPerson(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    // PUT /api/v1/persons/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.updatePerson(id, requestDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/v1/persons/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if (personService.deletePerson(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
