package com.github.nekoposer.panels;

import javax.swing.*;
import java.awt.*;

public class GridComponent extends JComponent {
    private int gridSizeHorizontal;
    private int gridSizeVertical;

    public GridComponent(int gridSizeHorizontal, int gridSizeVertical) {
        this.gridSizeVertical = gridSizeVertical;
        this.gridSizeHorizontal = gridSizeHorizontal;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Stroke  customStroke = new BasicStroke(1);
        g2d.setStroke(customStroke);

        int cellWidth = getWidth() / gridSizeHorizontal;
        int cellHeight = getHeight() / gridSizeVertical;

        for (int i = 1; i < gridSizeHorizontal; i++) {
            int x = i * cellWidth;
            g2d.drawLine(x, 0, x, getHeight());
        }

        for (int i = 1; i < gridSizeVertical; i++) {
            int y = i * cellHeight;
            g2d.drawLine(0, y, getWidth(), y);
        }
    }
}