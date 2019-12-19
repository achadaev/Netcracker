package com.example.server.controller;

import com.example.server.dao.PersonDAO;
import com.example.shared.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.io.IOException;

@Controller
public class RegistrationController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("registration", new Person());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute Person person, Model model) {
        try {
            personDAO.addPerson(person);
            model.addAttribute("person", person);
        } catch (IOException | ValidationException e) {
            e.printStackTrace();
            return "error";
        }
        return "result";
    }

    @GetMapping("/search")
    public String searchForm(Model model) {
        model.addAttribute("search", new Person());
        return "search";
    }


    @PostMapping("/search")
    public String searchSubmit(@ModelAttribute Person person, Model model) {
        try {
            Person foundPerson = personDAO.findPerson(person);
            if (foundPerson != null) {
                model.addAttribute("foundPerson", foundPerson);
                return "found";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "not-found";
    }

}
