package com.htpt.client.Models.Form;

import java.io.Serializable;

public class ResponsePing implements Serializable {
    
    private String status;
    private String message;
    private String data;

    public ResponsePing() {}

    public ResponsePing(String status, String message, String data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

    
}
