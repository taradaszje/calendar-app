package com.components;

import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class View extends JComboBox {


    private enum Period {
        Month, Week
    }

    public View() {
        addItem(Period.Week);
        addItem(Period.Month);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller controller = Controller.getInstance();
                controller.setButtonsView(getSelectedItem().toString()); //powiadomić calendarView o zmianie widoku
                controller.notifyAboutViewChange(controller.getButtonsView());
                controller.notifyAboutDateChange(controller.getDate());
            }
        });
    }


}
