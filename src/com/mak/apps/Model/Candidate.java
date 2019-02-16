package com.mak.apps.Model;

public class Candidate {
    private String name,party, pass;

    public Candidate(String name, String party, String pass) {
        this.name = name;
        this.party = party;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
