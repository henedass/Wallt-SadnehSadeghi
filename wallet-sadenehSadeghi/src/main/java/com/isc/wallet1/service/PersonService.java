package com.isc.wallet1.service;

import com.isc.wallet1.model.Person;
import com.isc.wallet1.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {

        return personRepository.save(person);
    }

    public Optional<Person> getPerson(Long id) {

        return personRepository.findById(id);
    }

    public void deletePerson(Long id) {

        personRepository.deleteById(id);
    }

    /*public Person updatePerson(Person person){

    }*/
}

