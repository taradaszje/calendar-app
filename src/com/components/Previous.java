package com.components;

import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Previous extends JButton implements ChangeDate {

    public Previous(){
        setText("<");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(Controller.getInstance().getView().getSelectedItem().toString());

                if(Controller.getInstance().getView().getSelectedItem().toString().equals("Month")){
                    Controller.getInstance().setDate(subOneMonth(Controller.getInstance().getDate()));
                    System.out.println(Controller.getInstance().getDate().toString());
                }
                else{
                    Controller.getInstance().setDate(subOneWeek(Controller.getInstance().getDate()));
                    System.out.println(Controller.getInstance().getDate().toString());
                }
                Controller.getInstance().notifyAll(Controller.getInstance().getDate(),
                        Controller.getInstance().getView().getSelectedItem().toString());
                Controller.getInstance().notifyAll(Controller.getInstance().getDate(),
                        Controller.getInstance().getView().getSelectedItem().toString());
            }
        });
        setVisible(true);
    }

    @Override
    public void updateDate(LocalDate date, String view) {

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

