package com.controller;

import com.navigation.DateTextField;
import com.navigation.Next;
import com.navigation.Previous;
import com.navigation.View;
import com.components.*;
import com.views.CalendarView;
import com.views.NotesView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    private static Controller ourInstance = new Controller();

    private LocalDate date = LocalDate.now();
    private ViewType viewType = ViewType.Week;
    private List<ChangeDate> dateList = new ArrayList();
    private List<ChangeView> viewList = new ArrayList();
    private View view = new View();
    private Previous previous = new Previous();
    private DateTextField dateTextField = new DateTextField();
    private CalendarView calendarView = new CalendarView();
    private NotesView notesView = new NotesView();
    private Next next = new Next();

    private Controller() {
        dateList.add(dateTextField);
        dateList.add(calendarView);
        viewList.add(calendarView);
        dateList.add(notesView);
    }

    public ViewType getViewType() {
        return viewType;
    }

    public void setViewType(ViewType viewType) {
        this.viewType = viewType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void notifyAboutDateChange(LocalDate date) {
        this.dateList.forEach(dateObserver -> dateObserver.updateDate(date));
    }

    public void notifyAboutViewChange(ViewType view) {
        this.viewList.forEach(viewObserver -> viewObserver.updateView(view));
    }

    public static Controller getInstance() {
        return ourInstance;
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

    public NotesView getNotesView() {
        return notesView;
    }
}
