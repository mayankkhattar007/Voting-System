package com.mak.apps.Utilities;

import com.mak.apps.Model.Candidate;
import com.mak.apps.Model.Vote;
import com.mak.apps.Model.Voter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

import static com.mak.apps.Utilities.FileUtils.ReadFromFile;

public class JSONUtils {

    public static ArrayList<Candidate> getCandidateList(){
        ArrayList<Candidate> candidates = new ArrayList<>();
        String raw = ReadFromFile(Constants.candidate_file);
        if (raw.isEmpty()){
            raw = "[]";
        }
        JSONParser parser = new JSONParser();
        JSONArray array;
        try {
            array = (JSONArray) parser.parse(raw);
            if (!array.isEmpty()) {
                for (Object anArray : array) {
                    JSONObject obj = (JSONObject) anArray;
                    candidates.add(new Candidate(String.valueOf(obj.get("name")), String.valueOf(obj.get("party"))
                            , String.valueOf(obj.get("pass"))));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return candidates;
    }

    public static void addCandidateData(ArrayList<Candidate> candidates){
        JSONArray array = new JSONArray();
        for (Candidate c:candidates){
            JSONObject object = new JSONObject();
            object.put("name",c.getName());
            object.put("party",c.getParty());
            object.put("pass",c.getPass());
            array.add(object);
        }
        FileUtils.WriteToFile(Constants.candidate_file,array.toJSONString());
    }

    public static ArrayList<Voter> getVotersList(){
        ArrayList<Voter> voters = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray) parser.parse(ReadFromFile(Constants.voters_file));
            for (Object o:array){
                JSONObject object = (JSONObject) o;
                voters.add(new Voter(
                        String.valueOf(object.get("id")),String.valueOf(object.get("name")),String.valueOf(object.get("status")),
                        String.valueOf(object.get("pass"))
                ));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return voters;
    }


    public static void addVote(Vote v){
        String votesdata = ReadFromFile(Constants.votes_file);
        if (votesdata.isEmpty()){
            JSONArray array = new JSONArray();
            JSONObject object = new JSONObject();
            object.put("party",v.getParty());
            object.put("id",v.getVoterid());
            array.add(object);
            FileUtils.WriteToFile(Constants.votes_file,array.toJSONString());
        } else {
            JSONParser parser = new JSONParser();
            JSONArray array = null;
            try {
                array = (JSONArray) parser.parse(votesdata);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject object = new JSONObject();
            object.put("party",v.getParty());
            object.put("id",v.getVoterid());
            array.add(object);
            FileUtils.WriteToFile(Constants.votes_file,array.toJSONString());
        }
    }

    public static ArrayList<Vote> getVotes(){
        ArrayList<Vote> votes=new  ArrayList<>();
        String votesdata = ReadFromFile(Constants.votes_file);
        if (votesdata.isEmpty()){
            votesdata=votesdata.concat("[]");
        }
        JSONParser parser = new JSONParser();
        JSONArray array;
        try {
            array = (JSONArray) parser.parse(votesdata);
            for (Object o :
                    array) {
                JSONObject oj = (JSONObject) o;
                votes.add(new Vote(String.valueOf(oj.get("party")),String.valueOf(oj.get("id"))));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return votes;
    }

}
