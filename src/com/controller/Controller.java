package com.controller;

import com.components.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Controller instance = new Controller();
    private LocalDate date = LocalDate.now();
    private ViewType viewType = ViewType.WEEK;
    private List<DateObserver> dateList = new ArrayList<>();
    private List<ViewObserver> viewList = new ArrayList<>();
    private List<NoteObserver> noteList = new ArrayList<>();
    private NotesService notesService = Notes.getInstance();

    private Controller() {
    }

    public void notifyObserver(LocalDate date, ViewType viewType) {
        notifyAboutViewChange(viewType);
        notifyAboutDateChange(date);
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

    public void notifyAboutViewNote(LocalDate date) {
        this.noteList.forEach(noteObserver -> noteObserver.viewNote(date));
    }

    public void addNoteObserver(NoteObserver noteObserver) {
        this.noteList.add(noteObserver);
    }

    public void addDateObserver(DateObserver dateObserver) {
        this.dateList.add(dateObserver);
    }

    public void addViewObserver(ViewObserver viewObserver) {
        this.viewList.add(viewObserver);
    }

    public static Controller getInstance() {
        return instance;
    }

    public NotesService getNotesService() {
        return notesService;
    }
}
