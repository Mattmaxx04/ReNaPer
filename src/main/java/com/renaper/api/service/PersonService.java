package com.renaper.api.service;

import com.renaper.api.exception.PersonNotFoundException;
import com.renaper.api.model.Person;
import com.renaper.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public Person findPersonByLastnameStartsWith(String lastname) {
        return personRepository.findPersonByLastnameStartsWith(lastname).orElseThrow(() ->
                new PersonNotFoundException("Persona denominada" + lastname + "no fue encontrada"));
    }

    public Person findByNameAndLastname(String name ,String lastname) {
        return personRepository.findByNameAndLastname(name, lastname).orElseThrow(() ->
                new PersonNotFoundException("Persona denominada " + name + lastname + " no fue encontrada"));
    }



    /*public Person findPersonByFullName(String FullName) {
        return personRepository.findPersonByFullName(FullName).orElseThrow(() ->
                new PersonNotFoundException("Persona denominada" + FullName + "no fue encontrada"));
    }*/

    public Person findPersonById(Long id) {
        return personRepository.findPersonById(id).orElseThrow(() ->
                new PersonNotFoundException("Persona de id" + id + "no fue encontrada"));
    }

}
