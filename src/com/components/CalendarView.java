package com.components;

import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;



public class CalendarView extends JPanel implements ChangeDate, ChangeView {

    private DayButton days[];
    public CalendarView(){

        days = new DayButton[7];
        LocalDate date = LocalDate.now();

        createButtons(date, "Week");
        days[0].setBackground(Color.GRAY);
    }

    void createButtons(LocalDate date, String view){
        this.removeAll();
        if(view.equals("Month")) {
            days = new DayButton[date.lengthOfMonth()];
            LocalDate temp = date;
            for (int i = 0; i < date.lengthOfMonth(); i++) {
                temp = date.minusDays(date.getDayOfMonth() - 1);
                temp = temp.plusDays(i);
                days[i] = new DayButton(temp.toString());
                this.add(days[i]);
            }
        }
        else{
            days = new DayButton[7];
            LocalDate temp = date;
            for (int i = 0; i < 7; i++) {
                temp = date.plusDays(i);
                days[i] = new DayButton(temp.toString());
                this.add(days[i]);
            }

        }
        updateUI();

    }

    @Override
    public void updateDate(LocalDate date) {

        for(DayButton day : this.getDays()){
            day.setBackground(new JButton().getBackground());
            if(day.getText().equals(date.toString())){
                day.setBackground(Color.GRAY);
            }
        }

    }

    public DayButton[] getDays() {
        return days;
    }

    @Override
    public void updateView(String view) {
        createButtons(Controller.getInstance().getDate(), Controller.getInstance().getButtonsView());

    }
}
