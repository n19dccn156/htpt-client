package com.htpt.client.Models.Form;

public class SignupModel {
    
    private String email;
    private String pass1;
    private String pass2;
    private String firstname;
    private String lastname;
    private String job;

    public SignupModel() {}

    public SignupModel(String email, String pass1, String pass2, String firstname, String lastname, String job) {
        this.email = email;
        this.pass1 = pass1;
        this.pass2 = pass2;
        this.firstname = firstname;
        this.lastname = lastname;
        this.job = job;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public String getPass1() {
        return pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getJob() {
        return job;
    }

    

}
