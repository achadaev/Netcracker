package com.example.server.dao;

import com.example.shared.model.Person;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PersonDAOImpl implements PersonDAO {

    String file = "src\\main\\resources\\db.txt";

    private boolean validateText(String str) {
        Pattern pattern = Pattern.compile("^[a-z]{2,15}$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    @Override
    public void addPerson(Person form) throws IOException, ValidationException {
        StringBuffer str = new StringBuffer();
        if (validateText(form.getName())
                && validateText(form.getSurname())
                && validateText(form.getPatronymic())) {
            str.append(form.getName() + "*");
            str.append(form.getSurname() + "*");
            str.append(form.getPatronymic() + "*");
        } else {
            throw new ValidationException("Use only [a-z] symbols");
        }
        str.append(form.getAge() + "*");
        str.append(form.getSalary() + "*");
        str.append(form.getEmail() + "*");
        str.append(form.getJob() + "%");

        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.append(str.toString());
        writer.close();
    }

    @Override
    public Person findPerson(Person person) throws IOException {
        Scanner input = new Scanner(new File(file));
        input.useDelimiter("[*%]");
        while(input.hasNext()) {
            String name = input.next();
            String surname = input.next();
            String patronymic = input.next();
            int age = input.nextInt();
            int salary = input.nextInt();
            String email = input.next();
            String job = input.next();
            if (name.equals(person.getName()) && surname.equals(person.getSurname())) {
                input.close();
                return new Person(name, surname, patronymic, age, salary, email, job);
            }
        }
        input.close();
        return null;
    }
}
