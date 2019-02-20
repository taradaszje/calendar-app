package com.components;

import com.controller.Controller;
import com.navigation.DayButton;

import java.time.LocalDate;


public enum ViewType {

    Week{
        @Override
        public void setDate(String object) {
            if(object.equals(">")){
                Controller.getInstance().setDate(Controller.getInstance().getDate().plusDays(7));
            }
            else if(object.equals("<")){
                Controller.getInstance().setDate(Controller.getInstance().getDate().minusDays(7));
            }
        }

        @Override
        public DayButton[] createButtons(LocalDate localDate) {
            DayButton[] days = new DayButton[7];
            LocalDate temp = localDate;
            for (int i = 0; i < 7; i++) {
                temp = localDate.plusDays(i);
                days[i] = new DayButton(temp.toString());
            }
            return days;
        }
    }, Month{
        @Override
        public void setDate(String object) {
            if(object.equals(">")){
                Controller.getInstance().setDate(Controller.getInstance().getDate().plusMonths(1));
            }
            else if(object.equals("<")){
                Controller.getInstance().setDate(Controller.getInstance().getDate().minusMonths(1));
            }
        }

        @Override
        public DayButton[] createButtons(LocalDate localDate) {
           DayButton[] days = new DayButton[localDate.lengthOfMonth()];
            LocalDate temp = LocalDate.of(localDate.getYear(), localDate.getMonth(),1);
            for (int i = 0; i < days.length; i++) {
                days[i] = new DayButton(temp.plusDays(i).toString());
            }
            return days;
        }
    };
    abstract public void setDate(String object);
    abstract public DayButton[] createButtons(LocalDate localDate);
}
