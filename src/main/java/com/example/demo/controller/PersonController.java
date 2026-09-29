package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public String getAllPersons(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "person";
    }

    @PostMapping
    public String savePerson(@ModelAttribute Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
    }
}
