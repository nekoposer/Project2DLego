package com.github.nekoposer.listeners;

import com.github.nekoposer.panels.DrawPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerChangeDetailColor implements ActionListener {
    private DrawPanel panel;

    public ActionListenerChangeDetailColor(DrawPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String color = e.getActionCommand();
        switch (color) {
            case "red":
                panel.setColor(Color.RED);
                break;
            case "orange":
                panel.setColor(Color.ORANGE);
                break;
            case "yellow":
                panel.setColor(Color.YELLOW);
                break;
            case "green":
                panel.setColor(Color.GREEN);
                break;
            case "cyan":
                panel.setColor(Color.CYAN);
                break;
            case "blue":
                panel.setColor(Color.BLUE);
                break;
            case "purple":
                panel.setColor(new Color(128, 0, 128));
                break;
            case "white":
                panel.setColor(Color.WHITE);
                break;
            case "black":
                panel.setColor(Color.BLACK);
                break;
            case "lightGreen":
                panel.setColor(new Color(0, 255, 127));
                break;
            case "pink":
                panel.setColor(new Color(255, 192, 203));
                break;
            default:
                break;
        }
    }
}