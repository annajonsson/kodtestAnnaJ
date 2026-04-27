package com.kodtestannaj.kodtestapi.controller;

import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/data")
    public List<Person> getAllPersons(@RequestParam(required = false) Long bookingId) {
        return personService.getAllPersons();
    }

}
