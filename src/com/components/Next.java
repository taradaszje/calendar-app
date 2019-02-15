package com.components;

import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Next extends JButton {

    public Next() {
        setText(">");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller controller = Controller.getInstance();
                if (controller.getButtonsView().equals("Month")) {
                    controller.setDate(controller.getDate().plusDays(controller.getDate().lengthOfMonth()));
                } else {
                    controller.setDate(controller.getDate().plusDays(7));
                }
                controller.notifyAboutViewChange(controller.getButtonsView());
                controller.notifyAboutDateChange(controller.getDate());
            }
        });
        setVisible(true);
    }

}
