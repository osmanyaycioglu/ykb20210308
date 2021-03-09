package com.training.micro;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.micro.basic.MyOtherObject;

import a.b.c.TestBean;

@SpringBootApplication

//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.micro",
//                                            "a.b.c"
//})

//@Controller
//@Service
//@Repository
//@Configuration

public class ProjectSpringApplication implements CommandLineRunner {

    @Autowired
    @Qualifier("ayse")
    private MyOtherObject       moo;

    private final MyOtherObject moo2;
    @Autowired
    @Qualifier("ayse")
    private MyOtherObject       moo3;
    @Autowired
    @Qualifier("ali")
    private MyOtherObject       moo4;

    private MyOtherObject       moo5;

    @Autowired
    private TestBean            testBean;

    public ProjectSpringApplication(@Qualifier("ayse") final MyOtherObject myOtherObjectParam) {
        this.moo2 = myOtherObjectParam;
    }

    @Autowired
    public void methodW(@Qualifier("ali") final MyOtherObject moo5Param) {
        this.moo5 = moo5Param;
    }

    @PostConstruct
    public void baslat() {
        System.out.println("Post Construct");
    }

    @PreDestroy
    public void oldur() {
        System.out.println("Pre Destroy");
    }

    @Override
    public void run(final String... argsParam) throws Exception {
        this.moo4.setStr("osman");
        this.moo.init();
        this.testBean.test();
    }

}
