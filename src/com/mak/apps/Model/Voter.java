package com.mak.apps.Model;

public class Voter {
    private String id,name,status,pass;

    public Voter(String id, String name, String status, String pass) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
