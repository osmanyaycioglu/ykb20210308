package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.services.PersonManager;

@RestController
@RequestMapping("/api/v1/person/management")
public class PersonController {

    @Autowired
    private PersonManager pm;

    @PostMapping("/add")
    public String add(@RequestBody final Person person) {
        this.pm.add(person);
        return "Added : " + person;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("pid") final Long personId) {
        return "Deleted : " + personId;
    }

    @GetMapping("/get")
    public Person get(@RequestParam("pid") final Long personId) {
        Person personLoc = new Person();
        personLoc.setSurname("yay");
        personLoc.setName("osman");
        return personLoc;
    }

    @GetMapping("/get/name")
    public Person get(@RequestParam("name") final String personName) {
        Person personLoc = new Person();
        personLoc.setSurname("yay");
        personLoc.setName("osman");
        return personLoc;
    }

}
