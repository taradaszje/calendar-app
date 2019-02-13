package com.controller;

import com.components.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    private static Controller ourInstance = new Controller();

    public static Controller getInstance() {
        return ourInstance;
    }

    LocalDate date = LocalDate.now();

    List<ChangeDate> dateList = new ArrayList();

    private View view = new View();
    private Previous previous = new Previous();
    private DateTextField dateTextField = new DateTextField();
    private CalendarView calendarView = new CalendarView();
    private Next next = new Next();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public View getView() {
        return view;
    }

    private Controller() {
        dateList.add(previous);
        dateList.add(next);
        dateList.add(view);
        dateList.add(dateTextField);
        dateList.add(calendarView);
    }


    public Previous getPrevious() {
        return previous;
    }

    public DateTextField getDateTextField() {
        return dateTextField;
    }

    public CalendarView getCalendarView() {
        return calendarView;
    }


    public Next getNext() {
        return next;
    }

    public void notifyAll(LocalDate date, String view){

        for(ChangeDate o : dateList){
            o.updateDate(date,view);
        }
    }


}
