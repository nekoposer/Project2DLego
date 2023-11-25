package com.github.nekoposer.listeners;

import com.github.nekoposer.panels.DrawPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerMute implements ActionListener {
    private boolean isMuted = false;
    private DrawPanel panel;
    private JButton muteButton;


    public ActionListenerMute(DrawPanel panel, JButton muteButton) {
        this.panel = panel;
        this.muteButton = muteButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        isMuted = !isMuted;
        if (!isMuted) {
            panel.playWavMusic("src\\Main\\Resources\\data\\glichery - Sea Of Problems.wav");
            muteButton.setIcon(new ImageIcon("src\\Main\\Resources\\data\\unmute.png"));
        } else {
            panel.stopWavMusic();
            muteButton.setIcon(new ImageIcon("src\\Main\\Resources\\data\\mute.png"));
        }
    }
}