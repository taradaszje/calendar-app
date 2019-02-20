package com.navigation;

import com.components.ViewType;
import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Next extends JButton {

    public Next() {
        setText(">");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller controller = Controller.getInstance();
                setStrategy(controller.getViewType());
                controller.notifyAboutViewChange(controller.getViewType());
                controller.notifyAboutDateChange(controller.getDate());
            }
        });
        setVisible(true);
    }

    private void setStrategy(ViewType viewType) {
        viewType.increaseDate();
    }
}
