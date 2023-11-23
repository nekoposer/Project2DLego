package com.github.nekoposer.listeners;

import com.github.nekoposer.panels.DrawPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerSetDetail implements ActionListener {
    private DrawPanel panel;

    public ActionListenerSetDetail(DrawPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String detailSize = e.getActionCommand();
        switch (detailSize) {
            case "1x1":
                panel.setDetail(1, 1);
                break;
            case "2x1":
                panel.setDetail(2, 1);
                break;
            case "2x2":
                panel.setDetail(2, 2);
                break;
            case "3x1":
                panel.setDetail(3, 1);
                break;
            case "3x2":
                panel.setDetail(3, 2);
                break;
            default:
                break;
        }
    }
}