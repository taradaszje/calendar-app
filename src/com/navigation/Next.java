package com.navigation;

import com.components.ViewType;
import com.controller.Controller;

import javax.swing.*;

public class Next extends JButton {

    public Next() {
        setText(">");
        addActionListener(actionEvent -> {
            Controller controller = Controller.getInstance();
            setStrategy(controller.getViewType());
            controller.notifyObserver(controller.getDate(), controller.getViewType());
        });
        setVisible(true);
    }

    private void setStrategy(ViewType viewType) {
        viewType.increaseDate();
    }
}
