package com.aqworlds.network;

public class RequestException extends Exception {

    private String type = "warning";

    public RequestException(String msg) {
        super(msg);
    }

    public RequestException(String msg, String type) {
        super(msg);
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
