package com.navigation;

import com.components.DateObserver;
import com.components.DateUtility;
import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateObserverTextField extends JTextField implements DateObserver {

    public DateObserverTextField() {
        Controller.getInstance().addDateObserver(this);
        this.setText(LocalDate.now().toString());
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    Controller controller = Controller.getInstance();
                    try {
                        LocalDate date = LocalDate.parse(getText(), DateUtility.getFormatter());
                        controller.setDate(date);
                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(new Frame(), "Nie tak kolego, popraw się.");
                    }
                    controller.notifyObserver(controller.getDate(),controller.getViewType());
                }
            }
        });
    }

    @Override
    public void updateDate(LocalDate date) {
        this.setText(date.toString());
    }
}
