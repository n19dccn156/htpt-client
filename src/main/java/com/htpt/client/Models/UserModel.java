package com.htpt.client.Models;

import java.io.Serializable;

public class UserModel implements Serializable {
    
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String job;

    public UserModel() {}

    public UserModel(String email, String password, String firstName, String lastName, String job) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "UserModel [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName="
                + lastName + ", job=" + job + "]";
    }

    public String toJson() {
        return "{\"email\":\""+email+"\",\"password\":\""+password+"\",\"firstName\":\""+firstName+"\",\"lastName\":\""+lastName+"\",\"job\":\""+job+"\"}";
    }

    
}
