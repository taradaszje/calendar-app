package com.controller;

import com.navigation.DateObserverTextField;
import com.navigation.Next;
import com.navigation.Previous;
import com.navigation.View;
import com.components.*;
import com.views.CalendarViewObserver;
import com.views.NotesView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    private static Controller ourInstance = new Controller();

    private LocalDate date = LocalDate.now();
    private ViewType viewType = ViewType.Week;
    private List<DateObserver> dateList = new ArrayList();
    private List<ViewObserver> viewList = new ArrayList();
    private View view = new View();
    private Previous previous = new Previous();
    private DateObserverTextField dateTextField = new DateObserverTextField();
    private CalendarViewObserver calendarView = new CalendarViewObserver();
    private NotesView notesView = new NotesView();
    private Next next = new Next();
    private NotesService notesService = new NotesMap();

    private Controller() {

        dateList.add(calendarView);
        viewList.add(calendarView);
        dateList.add(notesView);
        dateList.add(dateTextField);
    }

    public ViewType getViewType() {
        return viewType;
    }

    public void setViewType(ViewType viewType) {
        this.viewType = viewType;
        notifyAboutViewChange(this.viewType);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
        notifyAboutDateChange(date);
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

    public DateObserverTextField getDateTextField() {
        return dateTextField;
    }

    public CalendarViewObserver getCalendarView() {
        return calendarView;
    }

    public Next getNext() {
        return next;
    }

    public NotesView getNotesView() {
        return notesView;
    }
}
