package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.GreetingForm;

@Controller
public class HomeController {

	@GetMapping("/")
    public String startseite(Model model) {
        model.addAttribute("greetingForm", new GreetingForm());
        return "index";
    }

    @PostMapping("/hello")
    public String hello(@ModelAttribute GreetingForm greetingForm) {
        return "hello";
    }
}
