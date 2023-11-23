package com.github.nekoposer.listeners;

import com.github.nekoposer.panels.DrawPanel;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.Color;


public class ActionListenerChangeColor implements ActionListener {
    private CardLayout cardLayout;
    private String panelNameToSwitchTo;
    private Container container;
    private JPanel panel;
    private DrawPanel drawPanel;

    public ActionListenerChangeColor(CardLayout cardLayout, Container container, String panelNameToSwitchTo, JPanel panel, DrawPanel drawPanel) {
        this.cardLayout = cardLayout;
        this.panelNameToSwitchTo = panelNameToSwitchTo;
        this.container = container;
        this.panel = panel;
        this.drawPanel = drawPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String color = e.getActionCommand();
        JPanel temp = new JPanel();
        switch (color) {
            case "red":
                panel.setBackground(Color.RED);
                break;
            case "orange":
                panel.setBackground(Color.ORANGE);
                break;
            case "yellow":
                panel.setBackground(Color.YELLOW);
                break;
            case "green":
                panel.setBackground(Color.GREEN);
                break;
            case "cyan":
                panel.setBackground(Color.CYAN);
                break;
            case "blue":
                panel.setBackground(Color.BLUE);
                break;
            case "purple":
                panel.setBackground(new Color(128, 0, 128));
                break;
            case "clean":
                panel.setBackground(temp.getBackground());
                break;
            case "white":
                panel.setBackground(Color.WHITE);
                break;
            case "black":
                panel.setBackground(Color.BLACK);
                break;
            case "lightGreen":
                panel.setBackground(new Color(0, 255, 127));
                break;
            case "pink":
                panel.setBackground(new Color(255, 192, 203));
            default:
                break;
        }
        cardLayout.show(container, panelNameToSwitchTo);
        drawPanel.playWavMusic("D:\\intellij idea\\Lego\\data\\glichery - Sea Of Problems.wav");
    }
}