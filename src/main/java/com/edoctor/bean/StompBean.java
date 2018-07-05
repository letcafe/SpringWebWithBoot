package com.edoctor.bean;

public class StompBean {

    private String message;

    public StompBean() {
    }

    public StompBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
