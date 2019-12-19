package com.example.server.controller;

import com.example.server.dao.PersonDAO;
import com.example.shared.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.xml.bind.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class RegistrationController {

    @Autowired
    private PersonDAO personDAO;

    private static String UPLOADED_FOLDER = "src\\main\\resources\\uploaded\\";

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

    @GetMapping("/upload")
    public String uploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadSubmit(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Select a file");
            return "redirect:/upload-result";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            personDAO.addPerson(path.toString());

            redirectAttributes.addFlashAttribute("message", "File '" + file.getOriginalFilename() + "' was uploaded");
        } catch (IOException | ValidationException e) {
            e.printStackTrace();
        }

        return "redirect:/upload-result";
    }

    @GetMapping("/upload-result")
    public String uploadResult() {
        return "upload-result";
    }

}