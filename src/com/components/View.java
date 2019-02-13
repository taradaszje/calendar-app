package com.components;

import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class View extends JComboBox implements ChangeDate {


    private enum Period{
        Month,Week
    }

    public View(){
        addItem(Period.Week);
        addItem(Period.Month);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller.getInstance().notifyAll(Controller.getInstance().getDate(),
                        Controller.getInstance().getView().getSelectedItem().toString());
            }
        });
    }


    @Override
    public void updateDate(LocalDate date, String view) {

    }

}
