package com.mak.apps;

import com.mak.apps.Utilities.FileUtils;
import com.mak.apps.Views.ViewController;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        if (FileUtils.CreateDirSystem()) {
            ViewController.setStartFrame();
        } else {
            JOptionPane.showMessageDialog(null,"File directories were not created properly",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
