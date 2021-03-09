package com.training.micro.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Qualifier("ayse")
public class MyOtherObject {

    private String   str;

    @Autowired
    private MyObject myObject;

    public MyOtherObject() {
        super();
    }


    public void init() {
        System.out.println("Str : " + this.str);
        this.myObject.exec();
    }


    public String getStr() {
        return this.str;
    }


    public void setStr(final String strParam) {
        this.str = strParam;
    }

}
