package com.mak.apps.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUpFrame extends JFrame implements ActionListener {

    private Container c;
    private JButton voter,candidate,admin,field_off;
    public StartUpFrame(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(106, 255, 235));

        voter = new JButton("Voter");
        voter.setBounds(130,25,140,50);    //setting location and size of JButton
        voter.addActionListener(this);
        voter.setBackground(new Color(59, 89, 182));
        voter.setForeground(Color.WHITE);
        voter.setFocusPainted(false);
        voter.setFont(new Font("Tahoma", Font.BOLD, 12));

        candidate = new JButton("Candidate");
        candidate.setBounds(130,100,140,50);    //setting location and size of JButton
        candidate.addActionListener(this);
        candidate.setBackground(new Color(59, 89, 182));
        candidate.setForeground(Color.WHITE);
        candidate.setFocusPainted(false);
        candidate.setFont(new Font("Tahoma", Font.BOLD, 12));

        admin = new JButton("Admin");
        admin.setBounds(130,175,140,50);    //setting location and size of JButton
        admin.addActionListener(this);
        admin.setBackground(new Color(59, 89, 182));
        admin.setForeground(Color.WHITE);
        admin.setFocusPainted(false);
        admin.setFont(new Font("Tahoma", Font.BOLD, 12));

        field_off = new JButton("Field Officer");
        field_off.setBounds(130,250,140,50);    //setting location and size of JButton
        field_off.addActionListener(this);
        field_off.setBackground(new Color(59, 89, 182));
        field_off.setForeground(Color.WHITE);
        field_off.setFocusPainted(false);
        field_off.setFont(new Font("Tahoma", Font.BOLD, 12));

        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        voter.setCursor(cur);
        candidate.setCursor(cur);
        admin.setCursor(cur);
        field_off.setCursor(cur);

        c.add(voter);
        c.add(candidate);
        c.add(admin);
        c.add(field_off);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voter){
            ViewController.disposeStartFrame();
            ViewController.setLoginForm("voter");
        } else if (e.getSource() == candidate) {
            ViewController.disposeStartFrame();
            ViewController.setLoginForm("candidate");
        } else if (e.getSource() == admin) {
            ViewController.disposeStartFrame();
            ViewController.setLoginForm("admin");
        } else {
            ViewController.disposeStartFrame();
            ViewController.setLoginForm("field officer");
        }
    }
}
