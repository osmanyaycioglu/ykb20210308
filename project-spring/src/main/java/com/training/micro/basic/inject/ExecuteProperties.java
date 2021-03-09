package com.training.micro.basic.inject;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "exec")
public class ExecuteProperties {

    private Integer      language;
    private String       strs;
    private List<String> tests;

    public Integer getLanguage() {
        return this.language;
    }

    public void setLanguage(final Integer languageParam) {
        this.language = languageParam;
    }

    public String getStrs() {
        return this.strs;
    }

    public void setStrs(final String strsParam) {
        this.strs = strsParam;
    }

    public List<String> getTests() {
        return this.tests;
    }

    public void setTests(final List<String> testsParam) {
        this.tests = testsParam;
    }


}
