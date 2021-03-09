package com.training.micro.basic.inject;


public class ExecuteImpl3 implements IExecute {

    @Override
    public String execute(final String execStrParam) {
        return "Ola " + execStrParam;
    }

}
