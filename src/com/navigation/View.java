package com.navigation;

import com.components.ViewType;
import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JComboBox {


    public View() {
        addItem(ViewType.Month);
        addItem(ViewType.Week);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller controller = Controller.getInstance();
                controller.setViewType(ViewType.valueOf(getSelectedItem().toString())); //powiadomić calendarView o zmianie widoku
                controller.notifyAboutViewChange(controller.getViewType());
                controller.notifyAboutDateChange(controller.getDate());
            }
        });
    }


}
