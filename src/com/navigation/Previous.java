package com.navigation;

import com.components.ViewType;
import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Previous extends JButton {

    public Previous() {
        setText("<");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Controller controller = Controller.getInstance();
                if (controller.getViewType() == ViewType.Month ) {
                    controller.setDate(controller.getDate().minusDays(controller.getDate().lengthOfMonth()));
                } else if(controller.getViewType() == ViewType.Week) {
                    controller.setDate(controller.getDate().minusDays(7));
                }
                controller.notifyAboutViewChange(controller.getViewType());
                controller.notifyAboutDateChange(controller.getDate());
            }
        });
        setVisible(true);
    }
}

