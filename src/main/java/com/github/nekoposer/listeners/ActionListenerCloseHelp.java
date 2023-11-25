package com.github.nekoposer.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerCloseHelp implements ActionListener {
    private JFrame frame;

    public ActionListenerCloseHelp(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
    }
}