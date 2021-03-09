package com.training.micro.basic.inject;


public class ExecuteImpl1 implements IExecute {

    @Override
    public String execute(final String execStrParam) {
        return "Hello " + execStrParam;
    }

}
