package com.github.nekoposer.listeners;

import com.github.nekoposer.panels.DrawPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ActionListenerDownload implements ActionListener {
    private DrawPanel panel;
    private JPanel legoGame;
    private int number = 0;


    public ActionListenerDownload(DrawPanel panel, JPanel legoGame) {
        this.legoGame = legoGame;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.setOpaque(true);
        panel.setBackground(legoGame.getBackground());
        savePanel(panel, "download" + number + ".png");
        panel.setOpaque(false);
        ++number;
    }
    public static void savePanel(JPanel panel, String filePath) {
        try {
            BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            panel.paint(g2d);
            g2d.dispose();

            File file = new File(filePath);
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}