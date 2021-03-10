package com.training.micro.order.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.micro.order.models.Order;
import com.training.micro.order.models.PaymentRequest;

@Service
public class OrderService {

    @Autowired
    private RestTemplate rt;

    public String placeOrder(final Order order) {
        PaymentRequest pr = new PaymentRequest();
        pr.setAmount(BigDecimal.TEN);
        pr.setCustomerId(order.getCustomerId());
        pr.setCustomerName(order.getCustomerName());
        String postForObjectLoc = this.rt.postForObject("http://ACCOUNTING/api/v1/accounting/payment/pay",
                                                        pr,
                                                        String.class);
        return postForObjectLoc;
    }

}
