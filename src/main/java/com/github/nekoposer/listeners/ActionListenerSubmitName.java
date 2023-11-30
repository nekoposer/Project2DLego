package com.github.nekoposer.listeners;

import com.github.nekoposer.database.PostgreSQLConnect;
import com.github.nekoposer.panels.TextFieldName;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerSubmitName implements ActionListener {
    private TextFieldName frame;

    public ActionListenerSubmitName(TextFieldName frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!frame.getText().equals("")) {
            PostgreSQLConnect.insertDataIntoDB(frame.getText(), 0);
        }
        frame.dispose();
    }
}