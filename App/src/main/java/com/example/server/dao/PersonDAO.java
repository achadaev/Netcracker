package com.example.server.dao;

import com.example.shared.model.Person;

import java.io.IOException;

public interface PersonDAO {
    void addPerson(Person form) throws IOException;
    Person findPerson(Person person) throws IOException;
}
