package com.navigation;

import com.components.ChangeDate;
import com.components.DateUtillity;
import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateTextField extends JTextField implements ChangeDate {

    public DateTextField() {
        this.setText(LocalDate.now().toString());
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {}

            @Override
            public void keyPressed(KeyEvent keyEvent) {}

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    Controller controller = Controller.getInstance();
                    try {
                        LocalDate date = LocalDate.parse(getText(), DateUtillity.getFormatter());
                        controller.setDate(date);
                    }catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(new Frame(), "Nie tak kolego, popraw się.");
                    }
                    controller.notifyAboutViewChange(controller.getViewType());
                    controller.notifyAboutDateChange(controller.getDate());
                }
            }
        });
    }

    @Override
    public void updateDate(LocalDate date) {
        this.setText(date.toString());
    }
}
