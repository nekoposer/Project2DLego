package com.github.nekoposer.listeners;

import com.github.nekoposer.panels.DrawPanel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;

public class ActionListenerExitMenu implements ActionListener {
    private CardLayout cardLayout;
    private String panelNameToSwitchTo;
    private Container container;
    private DrawPanel panel;


    public ActionListenerExitMenu(CardLayout cardLayout, Container container, String panelNameToSwitchTo, DrawPanel panel) {
        this.cardLayout = cardLayout;
        this.panelNameToSwitchTo = panelNameToSwitchTo;
        this.container = container;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.clearGrid();
        cardLayout.show(container, panelNameToSwitchTo);
        panel.stopWavMusic();
    }

}