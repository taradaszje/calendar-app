package com.components;
//TODO coś z enumami
//TODO ogarnąć utility z date formaterem

//TODO i w sumie to poczekać na code review
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotesView extends JPanel implements ChangeDate{
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
        List<String> noteList = instance.notesMap.getOrDefault(date,new ArrayList<>());
        String temp = "";
        for(String note : noteList){
            temp = temp + note + "\n";
        }
        textArea.setText(temp);
    }
}
