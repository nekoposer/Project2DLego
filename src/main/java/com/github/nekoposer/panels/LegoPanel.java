package com.github.nekoposer.panels;

import javax.swing.*;
import java.awt.*;

public class LegoPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Stroke  customStroke = new BasicStroke(3);
        g2d.setStroke(customStroke);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(482, 0, 482, 533); //вертикальная
        g2d.drawLine(482, 32, 700, 32); //горизонтальная для кнопок
        g2d.drawLine(0, 482, 482, 482); //горизонтальная снизу


    }
}
