package com.mak.apps.Views;

import com.mak.apps.Model.Candidate;
import com.mak.apps.Model.Vote;
import com.mak.apps.Utilities.JSONUtils;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OfficerWindow extends JFrame implements ActionListener {
    private Container c;
    private ArrayList<Candidate> candidates;
    private JButton canbtn1,canbtn2,canbtn3,canbtn4,canbtn5;
    private static int y_axis = 75;
    private ArrayList<Vote> votes;

    private int totalcount;

    public OfficerWindow(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(106, 255, 235));

        JLabel title = new JLabel("Please click on candidate you want to see vote count of");
        title.setBounds(25,25,350,50);
        c.add(title);
        votes = JSONUtils.getVotes();
        candidates = JSONUtils.getCandidateList();
        totalcount =candidates.size();
        switch (totalcount){
            case 0:{
                JOptionPane.showMessageDialog(c,"Candidate list empty!");
                System.exit(-1);
            }break;
            case 1:{
                canbtn1 = getVoteBtn(0);
                c.add(canbtn1);
            }break;
            case 2:{
                canbtn1 = getVoteBtn(0);
                canbtn2 = getVoteBtn(1);
                c.add(canbtn1);c.add(canbtn2);
            }break;
            case 3:{
                canbtn1 = getVoteBtn(0);
                canbtn2 = getVoteBtn(1);
                canbtn3 = getVoteBtn(2);
                c.add(canbtn1);c.add(canbtn2);c.add(canbtn3);
            }break;
            case 4:{
                canbtn1 = getVoteBtn(0);
                canbtn2 = getVoteBtn(1);
                canbtn3 = getVoteBtn(2);
                canbtn4 = getVoteBtn(3);
                c.add(canbtn1);c.add(canbtn2);c.add(canbtn3);c.add(canbtn4);
            }break;
            case 5:{
                canbtn1 = getVoteBtn(0);
                canbtn2 = getVoteBtn(1);
                canbtn3 = getVoteBtn(2);
                canbtn4 = getVoteBtn(3);
                canbtn5 = getVoteBtn(4);
                c.add(canbtn1);c.add(canbtn2);c.add(canbtn3);c.add(canbtn4);c.add(canbtn5);
            }break;
        }
    }


    private JButton getVoteBtn(int i) {
        JButton votebtn =new JButton(candidates.get(i).getParty().toUpperCase());
        votebtn.setBounds(100,y_axis+(i*75),200,50);    //setting location and size of JButton
        votebtn.addActionListener(this);
        votebtn.setBackground(new Color(59, 89, 182));
        votebtn.setForeground(Color.WHITE);
        votebtn.setFocusPainted(false);
        votebtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        return votebtn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(canbtn1)){
            int votecount = getPartyVoteCount(0);
            JOptionPane.showMessageDialog(c,String.valueOf(votecount),"Vote count",JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource().equals(canbtn2)){
            int votecount = getPartyVoteCount(1);
            JOptionPane.showMessageDialog(c,String.valueOf(votecount),"Vote count",JOptionPane.INFORMATION_MESSAGE);
        } else if(e.getSource().equals(canbtn3)){
            int votecount = getPartyVoteCount(2);
            JOptionPane.showMessageDialog(c,String.valueOf(votecount),"Vote count",JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource().equals(canbtn4)){
            int votecount = getPartyVoteCount(3);
            JOptionPane.showMessageDialog(c,String.valueOf(votecount),"Vote count",JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource().equals(canbtn5)){
            int votecount = getPartyVoteCount(4);
            JOptionPane.showMessageDialog(c,String.valueOf(votecount),"Vote count",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private int getPartyVoteCount(int i) {
        int count=0;
        for (Vote vote:
             votes) {
            if (vote.getParty().equalsIgnoreCase(candidates.get(i).getParty())){
                count++;
            }
        }
        return count;
    }
}
