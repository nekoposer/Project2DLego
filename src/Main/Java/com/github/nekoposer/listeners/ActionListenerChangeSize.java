package com.github.nekoposer.listeners;

import com.github.nekoposer.panels.DrawPanel;
import com.github.nekoposer.panels.GridComponent;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;

public class ActionListenerChangeSize implements ActionListener {
    private CardLayout cardLayout;
    private String panelNameToSwitchTo;
    private Container container;
    private JPanel panel;
    private DrawPanel test;
    public ActionListenerChangeSize(CardLayout cardLayout, Container container, String panelNameToSwitchTo, JPanel panel, DrawPanel test) {
        this.cardLayout = cardLayout;
        this.panelNameToSwitchTo = panelNameToSwitchTo;
        this.container = container;
        this.panel = panel;
        this.test = test;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GridComponent temp;
        String size = e.getActionCommand();
        panel.removeAll();
        switch (size) {
            case "8x8":
                temp = new GridComponent(8, 8);
                temp.setBounds(0, 0, 480, 480);
                panel.add(temp);
                test.setSize(8, 8);
                break;
            case "16x16":
                temp = new GridComponent(16, 16);
                temp.setBounds(0, 0, 480, 480);
                panel.add(temp);
                test.setSize(16, 16);
                break;
            case "32x32":
                temp = new GridComponent(32, 32);
                temp.setBounds(0, 0, 480, 480);
                panel.add(temp);
                test.setSize(32, 32);
                break;
            default:
                break;
        }
        cardLayout.show(container, panelNameToSwitchTo);

    }
}