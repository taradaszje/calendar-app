package com.navigation;

import com.components.DateUtility;
import com.components.NotesMap;
import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;


public class DayButton extends JButton {

    private int counter;
    private LocalDate date = DateUtility.stringToDate(getText());

    public DayButton(String title) {
        super(title);
        addActionListener(actionEvent -> {
            setBackground(Color.GRAY);
            Controller controller = Controller.getInstance();
            controller.setDate(date);
        });
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (counter % 2 == 0) {
                    JOptionPane.showMessageDialog(new Frame(), Controller.getInstance().getDate().getDayOfWeek());
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                    String note = JOptionPane.showInputDialog("New note");
                    NotesMap.getInstance().addNote(date, note);
                }
                Controller.getInstance().notifyAboutViewNote(Controller.getInstance().getDate());
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
