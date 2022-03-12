package com.rest.webservice.webservice.Todo;

import static java.lang.String.format;

public class helloWorldBean {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public helloWorldBean(String message) {
        this.message =message;
    }

    @Override
    public String toString() {
        return String.format("helloWorldBean [message=%s]",message);
    }
}
