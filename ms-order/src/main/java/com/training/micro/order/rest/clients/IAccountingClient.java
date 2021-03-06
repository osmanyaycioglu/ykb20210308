package com.training.micro.order.rest.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.micro.error.client.RestClientException;
import com.training.micro.order.models.PaymentRequest;

@FeignClient("ACCOUNTING")
@RequestMapping("/api/v1/accounting/payment")
public interface IAccountingClient {

    @PostMapping("/pay")
    public String pay(@RequestBody final PaymentRequest pr) throws RestClientException;

}
