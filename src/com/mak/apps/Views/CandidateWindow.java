package com.mak.apps.Views;

import com.mak.apps.Model.Candidate;
import com.mak.apps.Model.Vote;
import com.mak.apps.Utilities.JSONUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CandidateWindow extends JFrame implements ActionListener {
    private Container c;
    private Candidate candidate;
    private ArrayList<Vote> votes;
    JLabel votecount;

    JButton exit = new JButton("Exit");

    public CandidateWindow(Candidate ca){
        this.candidate = ca;
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(106, 255, 235));
        JLabel title = new JLabel("Total votes in your account :");
        title.setBounds(25,25,350,50);
        c.add(title);
        votes = JSONUtils.getVotes();
        votecount = new JLabel(String.valueOf(getPartyVoteCount()));
        votecount.setFont(new Font("Tahoma", Font.BOLD, 72));
        votecount.setBounds(175,100,50,70);
        c.add(votecount);

        exit.setBounds(100,185,200,50);    //setting location and size of JButton
        exit.addActionListener(this);
        exit.setBackground(new Color(59, 89, 182));
        exit.setForeground(Color.WHITE);
        exit.setFocusPainted(false);
        exit.setFont(new Font("Tahoma", Font.BOLD, 12));
        c.add(exit);
    }


    private int getPartyVoteCount() {
        int count=0;
        for (Vote vote:
                votes) {
            if (vote.getParty().equalsIgnoreCase(candidate.getParty())){
                count++;
            }
        }
        return count;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exit)){
            ViewController.disposeCandidaterWindow();
            ViewController.setStartFrame();
        }
    }
}
