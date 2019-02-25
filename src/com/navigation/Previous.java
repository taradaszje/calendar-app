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
                setStrategy(controller.getViewType());
                controller.notifyObserver(controller.getDate(),controller.getViewType());
            }
        });
        setVisible(true);
    }

    private void setStrategy(ViewType viewType) {
        viewType.decreaseDate();
    }
}

