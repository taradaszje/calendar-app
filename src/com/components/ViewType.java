package com.components;

import com.controller.Controller;
import com.navigation.DayButton;

import java.time.LocalDate;

public enum ViewType {

    Week {
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

        @Override
        public void increaseDate() {
            Controller.getInstance().setDate(Controller.getInstance().getDate().plusDays(7));
        }

        @Override
        public void decreaseDate() {
            Controller.getInstance().setDate(Controller.getInstance().getDate().minusDays(7));
        }
    }, Month {
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

    abstract public DayButton[] createButtons(LocalDate localDate);

    abstract public void increaseDate();

    abstract public void decreaseDate();
}
