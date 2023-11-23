package com.github.nekoposer.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerHelp implements ActionListener {
    private JFrame frame;

    public ActionListenerHelp(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(true);
    }
}