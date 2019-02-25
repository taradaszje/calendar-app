package com.components;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesMap implements NotesService {

    private Map<LocalDate, List<String>> notesMap = new HashMap<>();
    private static NotesMap instance = new NotesMap();

    public static NotesMap getInstance() {
        return instance;
    }

    private NotesMap() {
    }

    @Override
    public void addNote(LocalDate date, String note) {
        List<String> temp = notesMap.getOrDefault(date, new ArrayList<>());
        temp.add(note);
        notesMap.put(date, temp);
    }

    @Override
    public void removeNote(LocalDate date) {
        notesMap.remove(date);
    }

    @Override
    public List<String> getNote(LocalDate date) {
        return notesMap.getOrDefault(date, new ArrayList<>());
    }

    private Map<LocalDate, List<String>> getNotesMap() {
        return notesMap;
    }

}
