package com.components;

import com.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Next extends JButton implements ChangeDate {

    public Next(){
        setText(">");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(Controller.getInstance().getView().getSelectedItem().toString().equals("Month")){
                    Controller.getInstance().setDate(addOneMonth(Controller.getInstance().getDate()));
                }
                else{
                    Controller.getInstance().setDate(addOneWeek(Controller.getInstance().getDate()));
                    System.out.println(Controller.getInstance().getDate().toString());

                }
                Controller.getInstance().notifyAll(Controller.getInstance().getDate(),
                        Controller.getInstance().getView().getSelectedItem().toString());
            }
        });
        setVisible(true);
    }

    @Override
    public void updateDate(LocalDate date, String view) {

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
