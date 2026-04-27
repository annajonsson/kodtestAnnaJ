package com.kodtestannaj.kodtestapi.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kodtestannaj.kodtestapi.exceptionhandler.CsvReadException;
import com.kodtestannaj.kodtestapi.model.Person;

@Component
public class FileHandler {

    public List<Person> loadPersons() { // Inspiration from old project and found getResourseAsStream help from here:
                                        // https://gist.github.com/sezina/8154994
        List<Person> persons = new ArrayList<>();

        InputStream inputStream = getClass().getResourceAsStream("/data.csv");
        if (inputStream == null) {
            throw new CsvReadException("csv file is null");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                inputStream))) {

            String line = null;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                persons.add(new Person(Long.parseLong(parts[0].trim()), parts[1].trim(),
                        Integer.parseInt(parts[2].trim()), parts[3].trim())); // Had to parse Long and int, error
                                                                              // otherwise
                                                                              // https://stackoverflow.com/questions/9935352/how-can-i-parse-integers-from-a-string-in-java

            }

        } catch (Exception e) {
            throw new CsvReadException("Error while reading Csv file");
        }

        return persons;

    }
}
