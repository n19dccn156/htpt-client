package com.htpt.client.Models;

import java.io.Serializable;

public class ResponseObject implements Serializable {
    
    private String status;
    private String message;
    private UserModel data;

    public ResponseObject() {}

    public ResponseObject(String status, String message, UserModel data) {
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

    public void setData(UserModel data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public UserModel getData() {
        return data;
    }

    
}
