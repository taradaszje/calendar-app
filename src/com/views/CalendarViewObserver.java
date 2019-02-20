package com.views;
//todo uproscic tworzenie buttonow
//todo instacja mapy cos tam

import com.components.DateObserver;
import com.components.ViewObserver;
import com.components.ViewType;
import com.navigation.DayButton;
import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;


public class CalendarViewObserver extends JPanel implements DateObserver, ViewObserver {

    private DayButton days[];

    public CalendarViewObserver() {
        //days = new DayButton[7];
        LocalDate date = LocalDate.now();
        days = setStrategy(ViewType.Week);
        createButtons(date, ViewType.Week);
        days[0].setBackground(Color.GRAY);
    }

    void createButtons(LocalDate date, ViewType view) {
        this.removeAll();
//        if (view == ViewType.Month) {                  //wrzucic enuma
//            days = new DayButton[date.lengthOfMonth()];
//            LocalDate temp = LocalDate.of(date.getYear(),date.getMonth(),1);
//            for (int i = 0; i < date.lengthOfMonth(); i++) {
//                days[i] = new DayButton(temp.plusDays(i).toString());
//                this.add(days[i]);
//            }
//        } else if(view == ViewType.Week) {                           // poprawić na else ifa
//            days = new DayButton[7];
//            LocalDate temp = date;
//            for (int i = 0; i < 7; i++) {
//                temp = date.plusDays(i);
//                days[i] = new DayButton(temp.toString());
//                this.add(days[i]);
//            }

            //}
       // this.days = setStrategy(Controller.getInstance().getViewType());
        setStrategy(Controller.getInstance().getViewType());
        updateUI();
    }

    @Override
    public void updateDate(LocalDate date) {

        for (DayButton day : this.getDays()) {
            if (day.getText().equals(date.toString())) {
                day.setBackground(Color.GRAY);
                day.setCounter(day.getCounter()+1);
            }else {
                day.setBackground(new JButton().getBackground());
                day.setCounter(0);
            }
        }
    }

    @Override
    public void updateView(ViewType view) {
        Controller controller = Controller.getInstance();
        createButtons(controller.getDate(), controller.getViewType());
    }
    private DayButton[] setStrategy(ViewType viewType){
        return viewType.createButtons(getDays(),Controller.getInstance().getDate());
    }

    public DayButton[] getDays() {
        return days;
    }
}
