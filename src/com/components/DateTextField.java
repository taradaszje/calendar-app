package com.components;

import com.controller.Controller;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTextField extends JTextField implements ChangeDate {

    public DateTextField(){
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
                if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER){
                    String typedDate = getText();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(typedDate, formatter);

                    Controller.getInstance().setDate(date);

                    Controller.getInstance().notifyAll(Controller.getInstance().getDate(),
                            Controller.getInstance().getView().getSelectedItem().toString());
                }
            }
        });
    }
    @Override
    public void updateDate(LocalDate date, String view) {
        this.setText(date.toString());
    }

}
