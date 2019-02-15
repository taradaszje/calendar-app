package com.components;

import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTextField extends JTextField implements ChangeDate {

    public DateTextField() {
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
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    try {
                        LocalDate date = LocalDate.parse(getText(), formatter);
                        controller.setDate(date);
                    }catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(new Frame(), "Nie tak kolego, popraw się.");

                    }

                    controller.notifyAboutDateChange(controller.getDate());
                    controller.notifyAboutViewChange(controller.getButtonsView());
                }
            }
        });
    }

    @Override
    public void updateDate(LocalDate date) {
        this.setText(date.toString());
    }

    private String validData(String data) {
        int day = 0, month = 0, year = 0;

        if (data.length() != 10) {

            return Controller.getInstance().getDate().toString();
        }

            year = Integer.parseInt(data.substring(0, 4));
            month = Integer.parseInt(data.substring(5, 7));
            day = Integer.parseInt(data.substring(8, 10));

            boolean checkMonth = (month > 0 && month < 13) ? true : false;
            boolean checkDay = (day > 0 && day < 31) ? true : false;
            boolean checkSplitter = (data.charAt(4) == '-' && data.charAt(7) == '-') ? true : false;

            if (checkDay && checkMonth && checkSplitter) {
                return data;
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Nie tak kolego, popraw się.");
                return Controller.getInstance().getDate().toString();
            }



    }
}
