package com.example.server.dao;

import com.example.shared.model.Person;

import javax.xml.bind.ValidationException;
import java.io.IOException;

public interface PersonDAO {
    void addPerson(Person form) throws IOException, ValidationException;
    void addPerson(String filename) throws IOException, ValidationException;
    Person findPerson(Person person) throws IOException;
}
