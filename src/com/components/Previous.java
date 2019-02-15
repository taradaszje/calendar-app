package com.components;

import com.controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Previous extends JButton {

    public Previous(){
        setText("<");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(Controller.getInstance().getButtonsView().equals("Month")){
                    Controller.getInstance().setDate(subOneMonth(Controller.getInstance().getDate()));
                    System.out.println(Controller.getInstance().getDate().toString());
                }
                else{
                    Controller.getInstance().setDate(subOneWeek(Controller.getInstance().getDate()));
                    System.out.println(Controller.getInstance().getDate().toString());
                }

                Controller.getInstance().notifyAboutViewChange(Controller.getInstance().getButtonsView());
                Controller.getInstance().notifyAboutDateChange(Controller.getInstance().getDate());
            }
        });
        setVisible(true);
    }


    public LocalDate subOneWeek(LocalDate date){
        date = date.minusDays(7);
        return date;
    }
    public LocalDate subOneMonth(LocalDate date){
        date = date.minusDays(date.lengthOfMonth());
        return date;
    }


}

