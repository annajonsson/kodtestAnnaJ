package com.kodtestannaj.kodtestapi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kodtestannaj.kodtestapi.csvUtils.FileHandler;
import com.kodtestannaj.kodtestapi.model.Person;

@Repository
public class PersonRepository {
    private final FileHandler fileHandler;

    public PersonRepository(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public List<Person> findAllPersons() {
        return fileHandler.loadPersons();
    }

}
