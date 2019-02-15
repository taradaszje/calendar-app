package com.controller;

import com.components.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    private static Controller ourInstance = new Controller();
    public static Controller getInstance() {
        return ourInstance;
    }
    LocalDate date = LocalDate.now();
    String buttonsView = "Week";
    private List<ChangeDate> dateList = new ArrayList();
    private List<ChangeView> viewList = new ArrayList();
    private View view = new View();
    private Previous previous = new Previous();
    private DateTextField dateTextField = new DateTextField();
    private CalendarView calendarView = new CalendarView();
    private Next next = new Next();

    private Controller() {
        dateList.add(dateTextField);
        dateList.add(calendarView);
        viewList.add(calendarView);

    }

    public String getButtonsView() {
        return buttonsView;
    }

    public void setButtonsView(String buttonsView) {
        this.buttonsView = buttonsView;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void notifyAboutDateChange(LocalDate date){

        this.dateList.forEach( o->o.updateDate(date) );

    }
    public void notifyAboutViewChange(String view){

        this.viewList.forEach( o->o.updateView(view) );

    }

    public View getView() {
        return view;
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
}
