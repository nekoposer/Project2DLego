package com.github.nekoposer.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerExit implements ActionListener {
    private JFrame frame;

    public ActionListenerExit(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
    }
}