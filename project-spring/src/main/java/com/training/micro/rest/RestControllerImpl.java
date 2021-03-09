package com.training.micro.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestControllerImpl {

    @GetMapping("/hello/{xyz}/{abc}/{qwe}")
    public String hello(@PathVariable("xyz") final String name,
                        @PathVariable("abc") final String surname,
                        @PathVariable("qwe") final int age) {
        return "Hello " + name + " " + surname + " " + age;
    }

    @GetMapping("/hello2")
    public String xyz(@RequestParam("xyz") final String name,
                      @RequestParam("abc") final String surname,
                      @RequestParam("qwe") final int age) {
        return "Hello 2 " + name + " " + surname + " " + age;
    }

    @GetMapping("/hello3/{xyz}")
    public String xyz2(@PathVariable("xyz") final String name,
                       @RequestParam("abc") final String surname,
                       @RequestParam("qwe") final int age) {
        return "Hello 3 " + name + " " + surname + " " + age;
    }

    @GetMapping("/hello4")
    public String xyz3(@RequestHeader("xyz") final String name,
                       @RequestHeader("abc") final String surname,
                       @RequestHeader("qwe") final int age) {
        return "Hello 4 " + name + " " + surname + " " + age;
    }


    @GetMapping("/hello1")
    public String hello1() {
        return "GET hello1";
    }

    @PostMapping("/hello1")
    public String hello2() {
        return "POST hello2";
    }

    @PutMapping("/hello1")
    public String hello3() {
        return "PUT hello3";
    }

    @DeleteMapping("/hello1")
    public String hello4() {
        return "DELETE hello4";
    }

}
