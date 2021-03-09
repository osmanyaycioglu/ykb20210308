package com.training.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Runner {

    public static void main(final String[] args) {
        ConfigurableApplicationContext runLoc = SpringApplication.run(ProjectSpringApplication.class,
                                                                      args);
        //        MyOtherObject beanLoc = runLoc.getBean(MyOtherObject.class);
        //        beanLoc.init();

        //        MyObject myObjectLoc = new MyObject();
        //        MyOtherObject myOtherObjectLoc = new MyOtherObject(myObjectLoc);
        //        myOtherObjectLoc.init();
    }

}
