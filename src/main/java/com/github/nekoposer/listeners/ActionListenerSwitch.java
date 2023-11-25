package com.github.nekoposer.listeners;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;

public class ActionListenerSwitch implements ActionListener {
    private CardLayout cardLayout;
    private String panelNameToSwitchTo;
    private Container container;
    private JFrame enterName;

    public ActionListenerSwitch(CardLayout cardLayout, Container container, String panelNameToSwitchTo, JFrame enterName) {
        this.cardLayout = cardLayout;
        this.panelNameToSwitchTo = panelNameToSwitchTo;
        this.container = container;
        this.enterName = enterName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("showNameField")) {
            enterName.setVisible(true);
        }
        cardLayout.show(container, panelNameToSwitchTo);
    }
}