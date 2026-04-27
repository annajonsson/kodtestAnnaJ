package com.kodtestannaj.kodtestapi.csvUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kodtestannaj.kodtestapi.exceptionhandler.CsvReadException;
import com.kodtestannaj.kodtestapi.model.Person;

@Component
public class FileHandler {

    public List<Person> loadPersons() {

        List<Person> persons = new ArrayList<>();

        // Loads csv file from (src/main/resources)
        InputStream inputStream = getClass().getResourceAsStream("/data.csv");
        if (inputStream == null) {
            throw new CsvReadException("csv file is empty");
        }

        // Used bufferedReader to read the file lne by line
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                inputStream))) {

            String line = null;
            br.readLine();
            while ((line = br.readLine()) != null) { // maps each row to a Person object
                String[] parts = line.split(";");
                persons.add(new Person(Long.parseLong(parts[0].trim()), parts[1].trim(),
                        Integer.parseInt(parts[2].trim()), parts[3].trim()));
            }

        } catch (Exception e) {
            throw new CsvReadException("Error while reading Csv file"); // throws custom exception, 500 internal error
        }

        return persons;

    }

}
