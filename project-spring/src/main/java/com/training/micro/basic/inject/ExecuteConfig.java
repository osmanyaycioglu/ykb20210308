package com.training.micro.basic.inject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
public class ExecuteConfig {

    @Autowired
    private Environment       env;

    @Value("${exec.language}")
    private int               language;

    @Value("'${exec.strs}'.split(',')")
    private List<String>      execStrs;

    @Autowired
    private ExecuteProperties ep;

    @Value("#{executeProperties.getLanguage()}")
    private Integer           langType;

    @Bean
    @Qualifier("sec")
    @Scope("prototype")
    // @RequestScope
    public IExecute executeImpl3() {
        switch (this.langType) {
            case 1:
                return new ExecuteImpl1();
            case 2:
                return new ExecuteImpl2();
            case 3:
                return new ExecuteImpl3();
            default:
                return new ExecuteImpl1();
        }
    }

    @Bean
    public IExecute executeImpl() {
        switch (this.language) {
            case 1:
                return new ExecuteImpl1();
            case 2:
                return new ExecuteImpl2();
            case 3:
                return new ExecuteImpl3();
            default:
                return new ExecuteImpl1();
        }
    }

    @Bean
    public IExecute executeImpl2() {
        String propertyLoc = this.env.getProperty("exec.language");
        int parseIntLoc = Integer.parseInt(propertyLoc);
        switch (parseIntLoc) {
            case 1:
                return new ExecuteImpl1();
            case 2:
                return new ExecuteImpl2();
            case 3:
                return new ExecuteImpl3();
            default:
                return new ExecuteImpl1();
        }
    }

    //    @Bean
    //    @Qualifier("en")
    //    public IExecute executeImpl() {
    //        return new ExecuteImpl1();
    //    }
    //
    //    @Bean
    //    @Qualifier("tr")
    //    public IExecute executeImpl2() {
    //        return new ExecuteImpl2();
    //    }
    //
    //    @Bean
    //    @Qualifier("es")
    //    public IExecute executeImpl3() {
    //        return new ExecuteImpl3();
    //    }

}
