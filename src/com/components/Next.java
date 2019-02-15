package com.components;

import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Next extends JButton {

    public Next(){
        setText(">");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(Controller.getInstance().getButtonsView().equals("Month")){
                    Controller.getInstance().setDate(addOneMonth(Controller.getInstance().getDate()));
                }
                else{
                    Controller.getInstance().setDate(addOneWeek(Controller.getInstance().getDate()));
                    System.out.println(Controller.getInstance().getDate().toString());

                }
                Controller.getInstance().notifyAboutViewChange(Controller.getInstance().getButtonsView());
                Controller.getInstance().notifyAboutDateChange(Controller.getInstance().getDate());

            }
        });
        setVisible(true);
    }


    public LocalDate addOneWeek(LocalDate date){
        date = date.plusDays(7);
        return date;
    }
    public LocalDate addOneMonth(LocalDate date){
        date = date.plusDays(date.lengthOfMonth());
        return date;
    }
}
