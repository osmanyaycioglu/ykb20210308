package com.training.micro.error;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "microservice")
public class ErrorConfig {

    private String name;
    private String subDomain;
    private String boundedContext;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSubDomain() {
        return this.subDomain;
    }

    public void setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public void setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
    }


    public ErrorObject createBaseError() {
        return new ErrorObject().setSubDomain(this.subDomain)
                                .setBoundedContext(this.boundedContext)
                                .setMicroservice(this.name);
    }
}
