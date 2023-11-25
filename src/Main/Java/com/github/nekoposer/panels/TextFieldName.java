package com.github.nekoposer.panels;

import com.github.nekoposer.listeners.ActionListenerSubmitName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldName extends JFrame {
    private JTextField textField;

    public TextFieldName() {
        setTitle("");
        Dimension helpSize = new Dimension(400, 150);
        setBounds(650, 270, 300, 150);
        setPreferredSize(helpSize);
        setLayout(new FlowLayout());

        JLabel chooseName = new JLabel("Enter your nickname");
        chooseName.setFont(new Font("Verdana", Font.BOLD, 14));
        textField = new JTextField(20);
        add(chooseName);
        add(textField);

        JButton submitButton = new JButton("Ok");
        add(submitButton);

        submitButton.addActionListener(new ActionListenerSubmitName(this));

    }
    public String getText() {
        return textField.getText();
    }
}