package com.kodtestannaj.kodtestapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodtestannaj.kodtestapi.model.Person;
import com.kodtestannaj.kodtestapi.repository.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }

    public List<Person> getAllPersons() {
        return personRepository.findAllPersons();
    }

    public List<Person> getLimitOfPersons(String limit) {
        List<Person> limitedNumberOfPersons = new ArrayList<>();
        List<Person> persons = getAllPersons();

        for (Person person : persons) {
            if (limitedNumberOfPersons.size() < Integer.parseInt(limit)) {

                limitedNumberOfPersons.add(person);
            }

        }
        return limitedNumberOfPersons;
    }
}
