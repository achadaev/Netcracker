package com.example.server.dao;

import com.example.shared.model.Person;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;

@Component
public class PersonDAOImpl implements PersonDAO {

    String file = "C:\\Projects\\Netcracker\\App\\src\\main\\resources\\db.txt";

    @Override
    public void addPerson(Person form) throws IOException {
        StringBuffer str = new StringBuffer();
        str.append(form.getName() + "*");
        str.append(form.getSurname() + "*");
        str.append(form.getPatronymic() + "*");
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
