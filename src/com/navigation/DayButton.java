package com.navigation;

import com.components.DateUtillity;
import com.components.NotesMap;
import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DayButton extends JButton {

    public DayButton(String title) {
        super(title);
        addActionListener(actionEvent -> {
            setBackground(Color.GRAY);
            Controller controller = Controller.getInstance();
            controller.setDate(DateUtillity.stringToDate(title));
            controller.notifyAboutDateChange(controller.getDate());
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
                if (SwingUtilities.isRightMouseButton(mouseEvent)) {

                    LocalDate date = LocalDate.parse(getText(), DateUtillity.getFormatter());
                    String note = JOptionPane.showInputDialog("New note");
                    NotesMap.getInstance().addNote(date,note);
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }
}
