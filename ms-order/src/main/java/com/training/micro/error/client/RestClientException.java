package com.training.micro.error.client;

import com.training.micro.error.ErrorObject;

public class RestClientException extends Exception {

    private static final long serialVersionUID = -2210792210459497177L;

    private ErrorObject       errorObject;
    private String            desc;

    public RestClientException() {
    }


    public RestClientException(final String descParam) {
        super();
        this.desc = descParam;
    }


    public ErrorObject getErrorObject() {
        return this.errorObject;
    }

    public void setErrorObject(final ErrorObject errorObjectParam) {
        this.errorObject = errorObjectParam;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }


}
