package com.github.nekoposer.listeners;

import com.github.nekoposer.database.PostgreSQLConnect;
import com.github.nekoposer.panels.DrawPanel;
import com.github.nekoposer.panels.TextFieldName;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.util.Map;

public class ActionListenerExitMenu implements ActionListener {
    private CardLayout cardLayout;
    private String panelNameToSwitchTo;
    private Container container;
    private DrawPanel panel;
    private JLabel label;
    private TextFieldName frame;

    public ActionListenerExitMenu(CardLayout cardLayout, Container container, String panelNameToSwitchTo, DrawPanel panel, JLabel label, TextFieldName frame) {
        this.cardLayout = cardLayout;
        this.panelNameToSwitchTo = panelNameToSwitchTo;
        this.container = container;
        this.panel = panel;
        this.label = label;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.clearGrid();
        cardLayout.show(container, panelNameToSwitchTo);
        panel.stopWavMusic();
        ActionListenerChangeColor.stopTimer();

        Map<String, Integer> result = PostgreSQLConnect.selectDataFromDB(frame.getText());
        int DBTime = result.get(frame.getText());

        String[] currentTimesArray = label.getText().split(":");
        int currentTime = 0;
        for (String temp : currentTimesArray) {
            currentTime += Integer.parseInt(temp);
        }

        int finalTime = currentTime + DBTime;
        PostgreSQLConnect.updateDataInDB(frame.getText(), finalTime);
    }
}