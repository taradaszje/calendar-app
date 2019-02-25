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
                throw new UnsupportedOperationException();
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    Controller controller = Controller.getInstance();
                    try {
                        LocalDate date = DateUtility.stringToDate(getText());
                        controller.setDate(date);
                        controller.notifyAboutViewChange(controller.getViewType());

                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(new Frame(), "Nie tak kolego, popraw się.");
                    }
                }
            }
        });
    }

    @Override
    public void updateDate(LocalDate date) {
        this.setText(date.toString());
    }
}
