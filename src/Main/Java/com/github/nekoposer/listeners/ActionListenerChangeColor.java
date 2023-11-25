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
    Thread timerThread;
    private static boolean timerRunning = false;
    private static int seconds = 0;
    private JLabel label;

    public ActionListenerChangeColor(CardLayout cardLayout, Container container, String panelNameToSwitchTo, JPanel panel, DrawPanel drawPanel, JLabel label, Thread timerThread) {
        this.cardLayout = cardLayout;
        this.panelNameToSwitchTo = panelNameToSwitchTo;
        this.container = container;
        this.panel = panel;
        this.drawPanel = drawPanel;
        this.label = label;
        this.timerThread = timerThread;

    }
    public void setTimer(JLabel timerLabel) {
        timerThread = new Thread(new Runnable() {
            public void run() {
                timerRunning = true;
                while (!Thread.interrupted() && timerRunning) {
                    try {
                        Thread.sleep(1000);
                        seconds++;
                        int minutes = seconds / 60;
                        int hours = minutes / 60;
                        int remainingSeconds = seconds % 60;
                        timerLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        timerThread.start();
    }
    public static void stopTimer() {
        timerRunning = false;
        seconds = 0;
    }
    public static int[] getCurrentTime(JLabel label) {
        int[] resultTimes = new int[3];
        String time = label.getText();
        String[] times = time.split(":");
        resultTimes[0] = Integer.parseInt(times[0]);
        resultTimes[1] = Integer.parseInt(times[1]);
        resultTimes[2] = Integer.parseInt(times[2]);

        return resultTimes;
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
        drawPanel.playWavMusic("src\\Main\\Resources\\data\\glichery - Sea Of Problems.wav");
        setTimer(label);

    }
}