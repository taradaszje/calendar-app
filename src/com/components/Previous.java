package com.components;

import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Previous extends JButton {

    public Previous() {
        setText("<");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Controller controller = Controller.getInstance();
                if (controller.getButtonsView().equals("Month")) {
                    controller.setDate(controller.getDate().minusDays(controller.getDate().lengthOfMonth()));
                } else {
                    controller.setDate(controller.getDate().minusDays(7));
                }
                controller.notifyAboutViewChange(controller.getButtonsView());
                controller.notifyAboutDateChange(controller.getDate());
            }
        });
        setVisible(true);
    }
}

