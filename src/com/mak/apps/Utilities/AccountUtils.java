package com.mak.apps.Utilities;

import com.mak.apps.Model.Candidate;
import com.mak.apps.Model.Voter;

import java.util.ArrayList;

public class AccountUtils {
    public static boolean verifyUserCredentials(String id, String pass, String type){
        switch (type) {
            case "voter": {
                ArrayList<Voter> voters = JSONUtils.getVotersList();
                for (Voter v :
                        voters) {
                    if (v.getId().equals(id) && v.getPass().equals(pass)){
                        return true;
                    }
                }
            }break;
            case "candidate": {
                ArrayList<Candidate> candidates = JSONUtils.getCandidateList();
                for (Candidate c: candidates){
                    if (c.getParty().equalsIgnoreCase(id) && c.getPass().equalsIgnoreCase(pass)){
                        return true;
                    }
                }
            }break;
            case "admin": {
                if (id.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("1234")){
                    return true;
                }
            }break;
            case "field officer": {
                if (id.equalsIgnoreCase("officer123") && pass.equalsIgnoreCase("1234")){
                    return true;
                }
            }break;
        }
        return false;
    }

    public static boolean AddNewCandidate(String user,String party,String age){
        ArrayList<Candidate> candidates = JSONUtils.getCandidateList();
        if (CandidateAddable()){
            candidates.add(new Candidate(user,party,age));
            JSONUtils.addCandidateData(candidates);
            return true;
        }
        return false;
    }
    public static boolean CandidateAddable(){
        return JSONUtils.getCandidateList().size() < 5;
    }

    public static boolean DeleteCandidate(String user,String party){
        int startsize,endsize,index = -1;
        ArrayList<Candidate> candidates = JSONUtils.getCandidateList();
        startsize = candidates.size();
        for (Candidate c : candidates) {
            if (c.getName().equalsIgnoreCase(user) && c.getParty().equalsIgnoreCase(party)){
                index = candidates.indexOf(c);
            }
        }
        if (index!= -1){
            candidates.remove(index);
        }
        endsize = candidates.size();
        if (endsize==startsize || startsize-1 != endsize){
            return false;
        }else {
            JSONUtils.addCandidateData(candidates);
            return true;
        }
    }
}
