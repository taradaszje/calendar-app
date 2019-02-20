package com.views;
import com.components.DateObserver;
import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NotesView extends JPanel implements DateObserver {
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea);

    public NotesView(){
        textArea.setText("Notes be here!");
        scrollPane.setPreferredSize(new Dimension(200,50));
        this.add(scrollPane);
        textArea.setEditable(false);
        setVisible(true);
    }

    @Override
    public void updateDate(LocalDate date) {
        String temp = String.join("\n", Controller.getInstance().getNotesService().getNote(date));
        textArea.setText(temp);
    }
}
