package com.mak.apps.Model;

public class Vote {
    private String party,voterid;

    public Vote(String party, String voterid) {
        this.party = party;
        this.voterid = voterid;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getVoterid() {
        return voterid;
    }

    public void setVoterid(String voterid) {
        this.voterid = voterid;
    }
}
