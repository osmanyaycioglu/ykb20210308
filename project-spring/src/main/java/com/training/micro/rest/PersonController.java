package com.training.micro.rest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.services.PersonManager;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/person/management")
@Validated
public class PersonController {


    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);


    @Autowired
    private PersonManager pm;

    @PostMapping(value = "/training",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person training(@RequestBody final Person person) {
        this.pm.add(person);
        return person;
    }

    @Operation(description = "xyz description", method = "POST", tags = "tag1")
    @PostMapping(value = "/custom/response")
    public ResponseEntity<Person> custom(@Validated @RequestBody final Person person) {
        //
        //        PersonController.logger.debug("Received : " + person);
        //
        //        PersonController.logger.debug("Received : %s ",
        //                                      person);
        //
        //        if (PersonController.logger.isDebugEnabled()) {
        //            PersonController.logger.debug("[PersonController][custom]-> Received : " + person);
        //        }

        // Yanlış kullanım
        //        String stringLoc = "fjkgdf" + person + " sdklfsdf " + person;
        //        for (int iLoc = 0; iLoc < 10; iLoc++) {
        //            stringLoc += "sdfsd";
        //        }

        if ((person.getName() == null)
            || person.getName()
                     .isEmpty()) {
            throw new IllegalArgumentException("name boş olamaz");
        }
        this.pm.add(person);
        return ResponseEntity.status(HttpStatus.OK)
                             .header("myheader",
                                     "xyz")
                             .body(person);
    }


    @PostMapping(value = "/input")
    public ResponseEntity<Person> custom2(@RequestBody final Person person,
                                          final HttpServletRequest hsr) {
        this.pm.add(person);
        return ResponseEntity.status(HttpStatus.OK)
                             .header("myheader",
                                     "xyz")
                             .body(person);
    }

    @PostMapping("/add")
    public String add(@RequestBody final Person person) {
        this.pm.add(person);
        return "Added : " + person;
    }

    @GetMapping("/delete")
    public String delete(@NotNull @Positive @RequestParam("pid") final Long personId) {
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
