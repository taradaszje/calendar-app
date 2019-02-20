package com.views;

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
        Controller.getInstance().addDateObserver(this);
        Controller.getInstance().addViewObserver(this);
        createButtons(ViewType.Week);
        days[0].setBackground(Color.GRAY);
    }

    void createButtons(ViewType view) {
        this.removeAll();
        days = setStrategy(view);
        for (DayButton day : getDays()) {
            add(day);
        }
        updateUI();
    }

    @Override
    public void updateDate(LocalDate date) {

        for (DayButton day : this.getDays()) {
            if (day.getText().equals(date.toString())) {
                day.setBackground(Color.GRAY);
                day.setCounter(day.getCounter() + 1);
            } else {
                day.setBackground(new JButton().getBackground());
                day.setCounter(0);
            }
        }
    }

    @Override
    public void updateView(ViewType view) {
        Controller controller = Controller.getInstance();
        createButtons(controller.getViewType());
    }

    private DayButton[] setStrategy(ViewType viewType) {
        return viewType.createButtons(Controller.getInstance().getDate());
    }

    public DayButton[] getDays() {
        return days;
    }
}
