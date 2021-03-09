package com.training.micro.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/person/query")
public class PersonQueryController {

    @GetMapping("/name")
    public Person getByName(@RequestParam("name") final String personName) {
        Person personLoc = new Person();
        personLoc.setSurname("yay");
        personLoc.setName("osman");
        return personLoc;
    }

    @GetMapping("/surname")
    public Person getBySurname(@RequestParam("name") final String personName) {
        Person personLoc = new Person();
        personLoc.setSurname("yay");
        personLoc.setName("osman");
        return personLoc;
    }

}
