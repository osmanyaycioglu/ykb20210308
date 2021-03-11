package com.training.micro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounting/payment")
public class PaymentController {

    @Value("${server.port}")
    private int port;

    @PostMapping("/pay")
    public String pay(@Validated @RequestBody final PaymentRequest pr) {
        return "payment success : " + this.port + " PR : " + pr;
    }

}
