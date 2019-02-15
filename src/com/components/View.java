package com.components;

import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class View extends JComboBox {


    private enum Period{
        Month,Week
    }

    public View(){
        addItem(Period.Week);
        addItem(Period.Month);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller.getInstance().setButtonsView(getSelectedItem().toString()); //powiadomić calendarView o zmianie widoku
                Controller.getInstance().notifyAboutViewChange(Controller.getInstance().getButtonsView());
                Controller.getInstance().notifyAboutDateChange(Controller.getInstance().getDate());
            }
        });
    }


}
