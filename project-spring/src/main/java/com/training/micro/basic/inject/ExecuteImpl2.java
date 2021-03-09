package com.training.micro.basic.inject;


public class ExecuteImpl2 implements IExecute {

    @Override
    public String execute(final String execStrParam) {
        return "Merhaba " + execStrParam;
    }

}
