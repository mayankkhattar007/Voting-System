package com.mak.apps.Views;

import com.mak.apps.Model.Candidate;
import com.mak.apps.Model.Voter;
import com.mak.apps.Utilities.AccountUtils;
import com.mak.apps.Utilities.JSONUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginForm extends JFrame implements ActionListener {
    private String type;
    private Container c;
    private JTextField userid = new JTextField();
    private JPasswordField passField = new JPasswordField();

    private JButton login = new JButton("Login");

    LoginForm(String type){
        this.type =type;
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(106, 255, 235));

        userid.setBounds(100,50,200,40);
        Font f = new Font("Arial", Font.BOLD, 18);
        userid.setFont(f);

        passField.setBounds(100,110,200,40);
        passField.setFont(f);

        login.setBounds(100,180,200,50);    //setting location and size of JButton
        login.addActionListener(this);
        login.setBackground(new Color(59, 89, 182));
        login.setForeground(Color.WHITE);
        login.setFocusPainted(false);
        login.setFont(new Font("Tahoma", Font.BOLD, 12));

        switch (type) {
            case "voter": {
                userid.setText("Enter voter id");
            }break;
            case "candidate": {
                userid.setText("Enter candidate id");
            }break;
            case "admin": {
                userid.setText("Enter admin id");
            }break;
            case "field officer": {
                userid.setText("Enter officer id");
            }break;
        }

        c.add(userid);
        c.add(passField);
        c.add(login);


    }

    private boolean isUserIdValid() {
        return userid.getText().length()>0 && userid.getText().length()<15;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== login){
            boolean allgood = true;
            if (!isUserIdValid()){
                allgood =false;
                JOptionPane.showMessageDialog(c,"user id must be <15 and >0","Error in user id",JOptionPane.ERROR_MESSAGE);
            }
            if (!isPasswordValid()){
                allgood = false;
                JOptionPane.showMessageDialog(c,"password must be = 4 chars","Error in password",JOptionPane.ERROR_MESSAGE);
            }
            if (allgood){
                if (AccountUtils.verifyUserCredentials(userid.getText(),new String(passField.getPassword()),type)){
                    ViewController.disposeLoginForm();
                    switch (type) {
                        case "voter": {
                            ArrayList<Voter> voters = JSONUtils.getVotersList();
                            Voter voter = null;
                            for (Voter v :
                                    voters) {
                                if (v.getId().equals(userid.getText()) &&
                                        v.getPass().equals(new String(passField.getPassword()))){
                                    voter = v;
                                }
                            }
                            ViewController.setUpVoterWindow(voter);
                        }break;
                        case "candidate": {
                            ArrayList<Candidate> candidates = JSONUtils.getCandidateList();
                            Candidate candidate =null;
                            for (Candidate c :
                                    candidates) {
                                if (c.getParty().equalsIgnoreCase(userid.getText()) &&
                                        c.getPass().equalsIgnoreCase(new String(passField.getPassword()))){
                                    candidate =c;
                                }
                            }
                            ViewController.setUpCandidateWindow(candidate);
                        }break;
                        case "admin": {
                            ViewController.setUpAdminWindow();
                        }break;
                        case "field officer": {
                            ViewController.setUpOfficerWindow();
                        }break;
                    }
                } else {
                    JOptionPane.showMessageDialog(c,"you have entered wrong credentials","Credential error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private boolean isPasswordValid() {
        return passField.getPassword().length==4;
    }
}
