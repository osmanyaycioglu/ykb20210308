package com.training.micro;


public class NotifyRequest {

    private String message;
    private String destination;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(final String destinationParam) {
        this.destination = destinationParam;
    }

    @Override
    public String toString() {
        return "NotifyRequest [message=" + this.message + ", destination=" + this.destination + "]";
    }


}
