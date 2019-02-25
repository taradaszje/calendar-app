package com.components;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notes implements NotesService {

    private Map<LocalDate, List<String>> notesMap = new HashMap<>();
    private static Notes instance = new Notes();

    public static Notes getInstance() {
        return instance;
    }

    private Notes() {
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
}
