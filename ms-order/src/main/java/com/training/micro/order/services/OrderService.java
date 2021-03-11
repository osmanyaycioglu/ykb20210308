package com.training.micro.order.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.micro.order.models.Order;
import com.training.micro.order.models.PaymentRequest;
import com.training.micro.order.rest.clients.IAccountingClient;

@Service
public class OrderService {

    @Autowired
    private RestTemplate      rt;

    @Autowired
    private EurekaClient      eurekaClient;

    @Autowired
    private IAccountingClient accountingClient;

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

    public String placeOrder2(final Order order) {
        PaymentRequest pr = new PaymentRequest();
        pr.setAmount(BigDecimal.TEN);
        pr.setCustomerId(order.getCustomerId());
        pr.setCustomerName(order.getCustomerName());
        return this.accountingClient.pay(pr);
    }


    public String placeOrder3(final Order order) {
        Application applicationLoc = this.eurekaClient.getApplication("ACCOUNTING");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
        }

        InstanceInfo ns = this.eurekaClient.getNextServerFromEureka("ACCOUNTING",
                                                                    false);
        RestTemplate restLoc = new RestTemplate();
        PaymentRequest pr = new PaymentRequest();
        pr.setAmount(BigDecimal.TEN);
        pr.setCustomerId(order.getCustomerId());
        pr.setCustomerName(order.getCustomerName());
        String postForObjectLoc = restLoc.postForObject("http://"
                                                        + ns.getIPAddr()
                                                        + ":"
                                                        + ns.getPort()
                                                        + "/api/v1/accounting/payment/pay",
                                                        pr,
                                                        String.class);
        return postForObjectLoc;
    }

}
