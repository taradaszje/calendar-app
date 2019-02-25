package com.components;

import com.controller.Controller;
import com.navigation.DayButton;

import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

public enum ViewType {

    WEEK {
        @Override
        public DayButton[] createButtons(LocalDate localDate) {
            DayButton[] days = new DayButton[7];
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            for (int i = 0; i < 7; i++) {
                days[i] = new DayButton( localDate.minusDays(dayOfWeek.getValue() - 1L).plusDays(i).toString() );
            }
            days[dayOfWeek.getValue()-1].setBackground(Color.GRAY);
            return days;
        }

        @Override
        public void increaseDate() {
            Controller.getInstance().setDate(Controller.getInstance().getDate().plusDays(7));
        }

        @Override
        public void decreaseDate() {
            Controller.getInstance().setDate(Controller.getInstance().getDate().minusDays(7));
        }
    },
    MONTH {
        @Override
        public DayButton[] createButtons(LocalDate localDate) {
            DayButton[] days = new DayButton[localDate.lengthOfMonth()];
            LocalDate temp = LocalDate.of(localDate.getYear(), localDate.getMonth(), 1);
            for (int i = 0; i < days.length; i++) {
                days[i] = new DayButton(temp.plusDays(i).toString());
            }
            return days;
        }

        @Override
        public void increaseDate() {
            Controller.getInstance().setDate(Controller.getInstance().getDate().plusMonths(1));
        }

        @Override
        public void decreaseDate() {
            Controller.getInstance().setDate(Controller.getInstance().getDate().minusMonths(1));
        }
    };

    public abstract DayButton[] createButtons(LocalDate localDate);

    public abstract void increaseDate();

    public abstract void decreaseDate();
}
