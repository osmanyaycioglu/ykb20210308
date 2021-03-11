package com.training.micro.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.order.models.Order;
import com.training.micro.order.services.OrderService;

@RestController
@RequestMapping("/api/v1/management/order/")
public class OrderController {

    @Autowired
    private OrderService os;

    @PostMapping("/place")
    public String place(@Validated @RequestBody final Order order) {
        return this.os.placeOrder(order);
    }

    @PostMapping("/place2")
    public String place2(@Validated @RequestBody final Order order) {
        return this.os.placeOrder2(order);
    }

}
