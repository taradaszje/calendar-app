package com.views;

import com.components.NoteObserver;
import com.components.NotesService;
import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NotesView extends JPanel implements NoteObserver {
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea);

    public NotesView() {
        Controller.getInstance().addNoteObserver(this);
        textArea.setText("Notes be here!");
        scrollPane.setPreferredSize(new Dimension(200, 50));
        this.add(scrollPane);
        textArea.setEditable(false);
        setVisible(true);
    }

    @Override
    public void viewNote(LocalDate date) {
        NotesService notes = Controller.getInstance().getNotesService();
        String temp = String.join("\n", notes.getNote(date));
        textArea.setText(temp);
    }
}
