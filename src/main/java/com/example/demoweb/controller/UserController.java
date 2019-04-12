package com.example.demoweb.controller;

import com.example.demoweb.model.Person;
import com.example.demoweb.repo.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demoweb")
public class UserController {

    @Autowired
    private IPersonaRepo repo;

    @GetMapping("/getUsers")
    public List<Person> getPersonList() {
       return repo.findAll();
    }

    @PostMapping("/createUser")
    public void savePerson(@RequestBody Person p) {
        repo.save(p);
    }

    @PutMapping("/updateUser")
    public void updatePerson(@RequestBody Person p) {
        repo.save(p);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        repo.deleteById(id);
    }
}
