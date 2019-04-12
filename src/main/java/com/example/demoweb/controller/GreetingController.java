package com.example.demoweb.controller;

import com.example.demoweb.model.Person;
import com.example.demoweb.repo.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private IPersonaRepo repo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

        Person p = new Person();
        p.setName(name);

        repo.save(p);

        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/getListPerson")
    public String getListPerson(Model model) {
                model.addAttribute("listPerson", repo.findAll());
        return "greeting";
    }

}
