package com.views;
import com.components.DateObserver;
import com.components.NotesMap;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        NotesMap instance = NotesMap.getInstance();
        List<String> noteList = instance.getNotesMap().getOrDefault(date,new ArrayList<>());
        String temp = String.join("\n",noteList);
        textArea.setText(temp);
    }
}
