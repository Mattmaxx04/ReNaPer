package com.renaper.api.repository;

import com.renaper.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByNameAndLastname(String name, String lastname);

    List<Person> findPersonByLastnameStartsWith(String lastname);
    Optional<Person> findPersonById(Long id);

}
