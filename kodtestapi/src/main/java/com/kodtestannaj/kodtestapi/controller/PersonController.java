package com.kodtestannaj.kodtestapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kodtestannaj.kodtestapi.exceptionhandler.NoContentException;
import com.kodtestannaj.kodtestapi.model.Person;
import com.kodtestannaj.kodtestapi.service.PersonService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;

    }

    // limit is set to String and gets parsed in personService, so it could be
    // checked as null or not for the Get-request
    @GetMapping("/api/data")
    public List<Person> getAllPersonsWithLimit(@RequestParam(required = false) String limit) {

        if (limit == null) {

            List<Person> persons = personService.getAllPersons();
            if (persons.isEmpty()) {
                throw new NoContentException("The list of persons was empty"); // Returns a 204 code if list is empty
            }
            return persons;
        }

        List<Person> persons = personService.getLimitOfPersons(limit);
        if (persons.isEmpty()) {
            throw new NoContentException("The list of persons was empty");
        }
        return persons;
    }

}
