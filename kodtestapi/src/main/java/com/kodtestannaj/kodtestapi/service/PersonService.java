package com.kodtestannaj.kodtestapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodtestannaj.kodtestapi.exceptionhandler.BadRequestException;
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
        int parsedInt = Integer.parseInt(limit);
        if (parsedInt < 0) {
            throw new BadRequestException("The limit number has to be a positive integer");
        }
        for (Person person : persons) {
            if (limitedNumberOfPersons.size() < Integer.parseInt(limit)) {

                limitedNumberOfPersons.add(person);
            }

        }
        return limitedNumberOfPersons;
    }
}
