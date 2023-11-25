package com.github.nekoposer.panels;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class DrawPanel extends JPanel {
    private int rows;
    private int cols;
    private boolean[][] grid;
    private Color color;
    private Color[][] colors;
    private int detailWidth;
    private int detailHeight;
    private Clip clip;
    private boolean isMousePressed = false;
    private int currentRow = -1;
    private int currentCol = -1;


    public DrawPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new boolean[rows][cols];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellWidth = getWidth() / cols;
        int cellHeight = getHeight() / rows;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col]) {
                    if (colors[row][col] == null) {
                        g.setColor(color);
                        g.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                        colors[row][col] = color;
                    } else {
                        g.setColor(colors[row][col]);
                        g.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                    }
                }
            }
        }
    }
    public void clearGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = false;
                colors[row][col] = null;
            }
        }
        color = null;
        repaint();
    }
    public void setSize(int row, int col) {
        this.rows = row;
        this.cols = col;
        this.grid = new boolean[rows][cols];
        this.colors = new Color[rows][cols];
        addGridMouseListener();
        repaint();
    }
    private void addGridMouseListener() {
        if (this.getMouseListeners().length > 0) {
            removeMouseListener(this.getMouseListeners()[0]);
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isMousePressed = true;
                handleMouseClick(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isMousePressed = false;
                currentRow = -1;
                currentCol = -1;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isMousePressed) {
                    handleMouseClick(e);
                }
            }
        });
    }
    private void handleMouseClick(MouseEvent e) {
        int cellWidth = getWidth() / cols;
        int cellHeight = getHeight() / rows;
        int clickedRow = e.getY() / cellHeight;
        int clickedCol = e.getX() / cellWidth;
        if (clickedRow < rows && clickedCol < cols) {
            if (clickedRow != currentRow || clickedCol != currentCol) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    boolean flag = false;
                    for (int i = 0; i < detailWidth; ++i) {
                        for (int k = 0; k < detailHeight; ++k) {
                            if (colors[clickedRow + k][clickedCol + i] != null) {
                                flag = true;
                            }
                        }
                    }
                    if (color != null && detailHeight != 0 && detailWidth != 0 && clickedCol + detailWidth <= cols && clickedRow + detailHeight <= rows) {
                        if (!flag) {
                            for (int i = 0; i < detailWidth; ++i) {
                                for (int k = 0; k < detailHeight; ++k) {
                                    grid[clickedRow + k][clickedCol + i] = true;
                                    colors[clickedRow + k][clickedCol + i] = null;
                                }
                            }
                        }
                    }
                    repaint();
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    boolean flag = false;
                    for (int i = 0; i < detailWidth; ++i) {
                        for (int k = 0; k < detailHeight; ++k) {
                            if (colors[clickedRow + k][clickedCol + i] == null) {
                                flag = true;
                            }
                        }
                    }
                    if (color != null && detailHeight != 0 && detailWidth != 0 && clickedCol + detailWidth <= cols && clickedRow + detailHeight <= rows) {
                        if (!flag) {
                            for (int i = 0; i < detailWidth; ++i) {
                                for (int k = 0; k < detailHeight; ++k) {
                                    grid[clickedRow + k][clickedCol + i] = false;
                                    colors[clickedRow + k][clickedCol + i] = null;
                                }
                            }
                        }
                    }
                    repaint();
                }
                currentRow = clickedRow;
                currentCol = clickedCol;
            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void setDetail(int detailWidth, int detailHeight) {
        this.detailWidth = detailWidth;
        this.detailHeight = detailHeight;
    }
    public void playWavMusic(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            clip = AudioSystem.getClip();
            clip.open(audioIn);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void stopWavMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}