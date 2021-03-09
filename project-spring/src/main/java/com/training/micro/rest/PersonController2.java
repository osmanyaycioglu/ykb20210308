package com.training.micro.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/person/management")
public class PersonController2 {

    @PutMapping
    public String add(@RequestBody final Person person) {
        return "Added : " + person;
    }

    @DeleteMapping
    public String delete(@RequestParam("pid") final Long personId) {
        return "Deleted : " + personId;
    }

    @GetMapping
    public Person get(@RequestParam("pid") final Long personId) {
        Person personLoc = new Person();
        personLoc.setSurname("yay");
        personLoc.setName("osman");
        return personLoc;
    }

}
