package com.mak.apps.Views;

import com.mak.apps.Model.Candidate;
import com.mak.apps.Model.Voter;

import javax.swing.*;

public class ViewController {
    private static StartUpFrame startUpFrame;
    private static LoginForm loginForm;
    private static AdminWindow adminWindow;
    private static VoterWindow voterWindow;
    private static OfficerWindow officerWindow;
    private static CandidateWindow candidateWindow;

    public static void setLoginForm(String type){
        loginForm = new LoginForm(type);
        loginForm.setVisible(true);
        loginForm.setResizable(false);
        loginForm.setTitle("Voting System");
        loginForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginForm.setBounds(100,50,400,400);
    }

    public static void disposeLoginForm(){
        if (loginForm!= null) {
            loginForm.dispose();
            loginForm = null;
        }
    }

    public static void setStartFrame(){
        startUpFrame = new StartUpFrame();
        startUpFrame.setVisible(true);
        startUpFrame.setResizable(false);
        startUpFrame.setTitle("Voting System");
        startUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        startUpFrame.setBounds(100,50,400,400);
    }
    public static void disposeStartFrame(){
        if (startUpFrame != null){
            startUpFrame.dispose();
            startUpFrame =null;
        }
    }

    public static void setUpAdminWindow(){
        adminWindow = new AdminWindow();
        adminWindow.setVisible(true);
        adminWindow.setResizable(false);
        adminWindow.setTitle("Voting System");
        adminWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminWindow.setBounds(100,50,400,400);
    }

    public static void disposeAdminWindow(){
        if (adminWindow != null){
            adminWindow.dispose();
            adminWindow = null;
        }
    }
    public static void setUpVoterWindow(Voter v){
        voterWindow = new VoterWindow(v);
        voterWindow.setVisible(true);
        voterWindow.setResizable(false);
        voterWindow.setTitle("Voting System");
        voterWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        voterWindow.setBounds(100,50,400,500);
    }

    public static void disposeVoterWindow(){
        if (voterWindow != null){
            voterWindow.dispose();
            voterWindow = null;
        }
    }
    public static void setUpOfficerWindow(){
        officerWindow = new OfficerWindow();
        officerWindow.setVisible(true);
        officerWindow.setResizable(false);
        officerWindow.setTitle("Voting System");
        officerWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        officerWindow.setBounds(100,50,400,500);
    }

    public static void disposeOfficerWindow(){
        if (officerWindow != null){
            officerWindow.dispose();
            officerWindow = null;
        }
    }
    public static void setUpCandidateWindow(Candidate c){
        candidateWindow = new CandidateWindow(c);
        candidateWindow.setVisible(true);
        candidateWindow.setResizable(false);
        candidateWindow.setTitle("Voting System");
        candidateWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        candidateWindow.setBounds(100,50,400,400);
    }

    public static void disposeCandidaterWindow(){
        if (candidateWindow != null){
            candidateWindow.dispose();
            candidateWindow = null;
        }
    }
}
