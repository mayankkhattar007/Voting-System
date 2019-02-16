package com.mak.apps.Views;

import com.mak.apps.Utilities.AccountUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow extends JFrame implements ActionListener {

    private Container c;
    private Font f = new Font("Arial", Font.BOLD, 18);
    private JButton add,delete;
    private JButton backbtn= new JButton("Back");

    private JTextField c_name,c_party,c_age;
    private JButton addnew,removeCand;
    public AdminWindow(){
        c = this.getContentPane();
        backbtn.addActionListener(this);
        backbtn.setBackground(new Color(59, 89, 182));
        backbtn.setForeground(Color.WHITE);
        backbtn.setFocusPainted(false);
        backbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        loadMainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add)){
            c.remove(add);
            c.remove(delete);
            c.validate();
            c.repaint();
            addNewCandidate();
        } else if (e.getSource().equals(delete)){
            c.remove(add);
            c.remove(delete);
            c.validate();
            c.repaint();
            removeCandidate();
        } else if (e.getSource().equals(addnew)){
            if (AccountUtils.AddNewCandidate(c_name.getText(),c_party.getText(),c_age.getText())){
                JOptionPane.showMessageDialog(c,"Candidate registered","success",JOptionPane.INFORMATION_MESSAGE);
                loadMainFrame();
            } else {
                JOptionPane.showMessageDialog(c,"Max amount of candidates are created. Cant add more!","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(backbtn)){
            loadMainFrame();
        }else if (e.getSource().equals(removeCand)){
            if (AccountUtils.DeleteCandidate(c_name.getText(),c_party.getText())){
                JOptionPane.showMessageDialog(c,"Candidate deleted","success",JOptionPane.INFORMATION_MESSAGE);
                loadMainFrame();
            } else {
                JOptionPane.showMessageDialog(c,"Candidate not found","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadMainFrame(){
        c.removeAll();
        c.validate();
        c.repaint();
        c.setLayout(null);
        c.setBackground(new Color(106, 255, 235));

        add = new JButton("Add candidate");
        add.setBounds(100,100,200,50);    //setting location and size of JButton
        add.addActionListener(this);
        add.setBackground(new Color(59, 89, 182));
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add.setFont(new Font("Tahoma", Font.BOLD, 12));

        delete = new JButton("delete candidate");
        delete.setBounds(100,200,200,50);    //setting location and size of JButton
        delete.addActionListener(this);
        delete.setBackground(new Color(59, 89, 182));
        delete.setForeground(Color.WHITE);
        delete.setFocusPainted(false);
        delete.setFont(new Font("Tahoma", Font.BOLD, 12));

        c.add(add);
        c.add(delete);
    }

    private void removeCandidate() {
        c_name = new JTextField();
        c_party =new JTextField();

        c_name.setFont(f);
        c_party.setFont(f);

        c_name.setText("Enter name");
        c_party.setText("Enter party name");
        c_name.setBounds(100,20,200,40);
        c_party.setBounds(100,80,200,40);

        removeCand = new JButton("REMOVE candidate");
        removeCand.setBounds(100,200,200,50);    //setting location and size of JButton
        removeCand.addActionListener(this);
        removeCand.setBackground(new Color(59, 89, 182));
        removeCand.setForeground(Color.WHITE);
        removeCand.setFocusPainted(false);
        removeCand.setFont(new Font("Tahoma", Font.BOLD, 12));

        backbtn.setBounds(100,270,200,50);

        c.add(c_name);
        c.add(c_party);
        c.add(removeCand);
        c.add(backbtn);
    }

    private void addNewCandidate() {
        c_name = new JTextField();
        c_party =new JTextField();
        c_age =new JTextField();
        addnew = new JButton("ADD candidate");

        c_name.setFont(f);
        c_party.setFont(f);
        c_age.setFont(f);
        c_name.setText("Enter name");
        c_party.setText("Enter party name");
        c_age.setText("Enter password");

        c_name.setBounds(100,20,200,40);
        c_party.setBounds(100,80,200,40);
        c_age.setBounds(100,140,200,40);

        addnew.setBounds(100,200,200,50);    //setting location and size of JButton
        addnew.addActionListener(this);
        addnew.setBackground(new Color(59, 89, 182));
        addnew.setForeground(Color.WHITE);
        addnew.setFocusPainted(false);
        addnew.setFont(new Font("Tahoma", Font.BOLD, 12));

        backbtn.setBounds(100,270,200,50);

        c.add(c_name);
        c.add(c_party);
        c.add(c_age);
        c.add(addnew);
        c.add(backbtn);
    }
}
