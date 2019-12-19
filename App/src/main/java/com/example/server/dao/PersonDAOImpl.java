package com.example.server.dao;

import com.example.shared.model.Person;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;
import java.io.*;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PersonDAOImpl implements PersonDAO {

    String file = "src\\main\\resources\\db.txt";

    private boolean validateText(String str) {
        Pattern pattern = Pattern.compile("^[a-z]{2,15}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    @Override
    public void addPerson(Person person) throws IOException, ValidationException {
        StringBuffer str = new StringBuffer();
        if (validateText(person.getName())
                && validateText(person.getSurname())
                && validateText(person.getPatronymic())) {
            str.append(person.getName() + "*");
            str.append(person.getSurname() + "*");
            str.append(person.getPatronymic() + "*");
        } else {
            throw new ValidationException("Use only [a-z] symbols");
        }
        str.append(person.getAge() + "*");
        str.append(person.getSalary() + "*");
        str.append(person.getEmail() + "*");
        str.append(person.getJob() + "%");

        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.append(str.toString());
        writer.close();
    }

    private Person readNext(Scanner scanner) {
        String name = scanner.next();
        String surname = scanner.next();
        String patronymic = scanner.next();
        int age = scanner.nextInt();
        int salary = scanner.nextInt();
        String email = scanner.next();
        String job = scanner.next();

        return new Person(name, surname, patronymic, age, salary, email, job);
    }

    @Override
    public void addPerson(String filename) throws IOException, ValidationException {
        Scanner input = new Scanner(new File(filename));
        input.useDelimiter("[*%]");
        if (input.hasNext()) {
            addPerson(readNext(input));
        }
        input.close();
    }

    @Override
    public Person findPerson(Person person) throws IOException {
        Scanner input = new Scanner(new File(file));
        input.useDelimiter("[*%]");
        while (input.hasNext()) {
            Person foundPerson = readNext(input);
            if (foundPerson.getName().equals(person.getName()) && foundPerson.getSurname().equals(person.getSurname())) {
                input.close();
                return foundPerson;
            }
        }
        input.close();
        return null;
    }
}
