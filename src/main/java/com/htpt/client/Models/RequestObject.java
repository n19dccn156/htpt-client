package com.htpt.client.Models;

import java.net.Inet4Address;

public class RequestObject {
    
    private String ip;
    private String name;
    private String request;
    private Object params;

    public RequestObject() {}
    
    public RequestObject(String request, Object params) {
        try {
            Inet4Address add = (Inet4Address) Inet4Address.getLocalHost();
            this.ip = add.getHostAddress();
            this.name = add.getHostName();
            this.request = request;
            this.params = params;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public String getRequest() {
        return request;
    }

    public Object getParams() {
        return params;
    }

    
}
