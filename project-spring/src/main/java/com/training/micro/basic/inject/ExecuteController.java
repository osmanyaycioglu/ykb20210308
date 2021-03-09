package com.training.micro.basic.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exec")
// @RequestScope
// @SessionScope
public class ExecuteController {

    @Autowired
    @Qualifier("sec")
    private IExecute exec;

    @GetMapping("/hello")
    public String hello() {
        return this.exec.execute("osman");
    }

}
