package com.components;

import com.controller.Controller;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// stworzyc button spełniający wymagane założenia tj.
// po kliknieciu w niego ma zapisac notatke
// zmienić focus
// zmienić date w textfildzie

public class DayButton extends JButton {

    public DayButton(String title){
        super(title);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                    setBackground(Color.GRAY);
                    Controller.getInstance().setDate(stringToDate(title));
                    Controller.getInstance().notifyAboutDateChange(Controller.getInstance().getDate());

            }
        });
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                if(SwingUtilities.isRightMouseButton(mouseEvent)){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(getText(), formatter);

                    String note = JOptionPane.showInputDialog("New note");
                    if(!NotesMap.notes.containsKey(date)) {
                        List<String> notes = new ArrayList<String>();
                        notes.add(note);
                        NotesMap.notes.put(date, notes);
                    }
                    else{
                        NotesMap.notes.get(date).add(note);
                    }


                }
                System.out.println(NotesMap.notes.size());
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }
    public LocalDate stringToDate(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date;
    }

}
