package com.training.micro;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@EnableAsync
@EnableFeignClients
public class MsOrderApplication {

    @Scheduled(fixedDelay = 10_000)
    public void exec() {
        System.out.println("çalıştım : " + LocalDateTime.now());
    }

    @Async
    public Future<String> asyncFunction() {
        return CompletableFuture.completedFuture("test");
    }

    public static void main(final String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

}
