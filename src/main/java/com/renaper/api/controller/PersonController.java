package com.renaper.api.controller;


import com.renaper.api.model.Person;
import com.renaper.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> person = personService.findAllPersons();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

   @GetMapping("/find/{lastname}")
    public ResponseEntity<Person> findPersonByLastnameStartsWith(@PathVariable("lastname") String lastname) {
        Person person = personService.findPersonByLastnameStartsWith(lastname);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/NameAndLastname/{name} {lastname}")
    public ResponseEntity<Person> findByNameAndLastname(
              @PathVariable("name") String name, @PathVariable("lastname") String lastname  ) {
        Person person = personService.findByNameAndLastname(name, lastname);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson (@RequestBody Person person) {
        Person newPerson = personService.addPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @PutMapping("/update/")
    public ResponseEntity<Person> updatePerson (@RequestBody Person person) {
        Person updatePerson = personService.updatePerson(person);
        return new ResponseEntity<>(updatePerson, HttpStatus.OK);
    }

}
