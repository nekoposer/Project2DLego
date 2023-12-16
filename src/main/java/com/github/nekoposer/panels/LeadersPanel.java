package com.github.nekoposer.panels;

import com.github.nekoposer.database.PostgreSQLConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;
import java.util.List;

public class LeadersPanel extends JPanel {

    private JTable table;

    public LeadersPanel() {
        DefaultTableModel model = new DefaultTableModel();
        List<Map<String, Integer>> data = PostgreSQLConnect.selectAllFromDB();

        model.addColumn("№");
        model.addColumn("Name");
        model.addColumn("Time");

        for (int i = 0; i < data.size(); ++i) {
            Map<String, Integer> temp = data.get(i);
            for (Map.Entry<String, Integer> pair : temp.entrySet()) {
                int seconds = pair.getValue();
                int hours = seconds / 3600;
                seconds %= 3600;
                int minutes = seconds / 60;
                seconds %= 60;
                String formatTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                model.addRow(new Object[]{i + 1, pair.getKey(), formatTime});
            }
        }

        table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setRowHeight(20);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}