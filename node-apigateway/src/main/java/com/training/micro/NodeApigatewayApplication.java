package com.training.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class NodeApigatewayApplication {

    public static void main(final String[] args) {
        SpringApplication.run(NodeApigatewayApplication.class,
                              args);
    }

}
