package com.training.micro.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import a.b.c.TestConfig;

@Configuration
@Import(TestConfig.class)
@PropertySource("classpath:my.properties")
//@Profile("dev")
public class MyConfig {

    @Bean
    @Qualifier("ali")
    public MyOtherObject myOtherObject2() {
        return new MyOtherObject();
    }

}
