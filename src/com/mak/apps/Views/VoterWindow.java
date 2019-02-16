package com.mak.apps.Views;

import com.mak.apps.Model.Candidate;
import com.mak.apps.Model.Vote;
import com.mak.apps.Model.Voter;
import com.mak.apps.Utilities.JSONUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VoterWindow extends JFrame implements ActionListener {
    private Container c;
    private ArrayList<Candidate> candidates;
    private JButton votebtn1,votebtn2,votebtn3,votebtn4,votebtn5;
    private static int y_axis = 75;

    private int totalcount;
    private Voter v;

    public VoterWindow(Voter voter){
        v = voter;
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(106, 255, 235));

        JLabel title = new JLabel("Please click on candidate you want to vote for");
        title.setBounds(50,25,300,50);
        c.add(title);

        candidates = JSONUtils.getCandidateList();
        totalcount =candidates.size();
        switch (totalcount){
            case 0:{
                JOptionPane.showMessageDialog(c,"Candidate list empty!");
                System.exit(-1);
            }break;
            case 1:{
                votebtn1 = getVoteBtn(candidates.get(0),0);
                c.add(votebtn1);
            }break;
            case 2:{
                votebtn1 = getVoteBtn(candidates.get(0),0);
                votebtn2 = getVoteBtn(candidates.get(1),1);
                c.add(votebtn1);c.add(votebtn2);
            }break;
            case 3:{
                votebtn1 = getVoteBtn(candidates.get(0),0);
                votebtn2 = getVoteBtn(candidates.get(1),1);
                votebtn3 = getVoteBtn(candidates.get(2),2);
                c.add(votebtn1);c.add(votebtn2);c.add(votebtn3);
            }break;
            case 4:{
                votebtn1 = getVoteBtn(candidates.get(0),0);
                votebtn2 = getVoteBtn(candidates.get(1),1);
                votebtn3 = getVoteBtn(candidates.get(2),2);
                votebtn4 = getVoteBtn(candidates.get(3),3);
                c.add(votebtn1);c.add(votebtn2);c.add(votebtn3);c.add(votebtn4);
            }break;
            case 5:{
                votebtn1 = getVoteBtn(candidates.get(0),0);
                votebtn2 = getVoteBtn(candidates.get(1),1);
                votebtn3 = getVoteBtn(candidates.get(2),2);
                votebtn4 = getVoteBtn(candidates.get(3),3);
                votebtn5 = getVoteBtn(candidates.get(4),4);
                c.add(votebtn1);c.add(votebtn2);c.add(votebtn3);c.add(votebtn4);c.add(votebtn5);
            }break;
        }
    }

    private JButton getVoteBtn(Candidate candidate,int i) {
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
        if (e.getSource().equals(votebtn1)){
            JSONUtils.addVote(new Vote(votebtn1.getText(),v.getId()));
        } else if (e.getSource().equals(votebtn2)){
            JSONUtils.addVote(new Vote(votebtn2.getText(),v.getId()));
        } else if (e.getSource().equals(votebtn3)){
            JSONUtils.addVote(new Vote(votebtn3.getText(),v.getId()));
        } else if (e.getSource().equals(votebtn4)){
            JSONUtils.addVote(new Vote(votebtn4.getText(),v.getId()));
        } else if (e.getSource().equals(votebtn5)){
            JSONUtils.addVote(new Vote(votebtn5.getText(),v.getId()));
        }
        ViewController.disposeVoterWindow();
        ViewController.setStartFrame();
    }
}
