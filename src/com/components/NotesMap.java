package com.components;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesMap implements NotesService{

    private Map<LocalDate, List<String>> notesMap = new HashMap<>();
    private static NotesMap ourInstance = new NotesMap();

    public static NotesMap getInstance() {
        return ourInstance;
    }

    private NotesMap() {
    }

    @Override
    public void addNote(LocalDate date, String note) {
       List<String> temp = notesMap.getOrDefault(date, new ArrayList<String>());
       temp.add(note);
       notesMap.put(date,temp);
    }

    public Map<LocalDate, List<String>> getNotesMap() {
        return notesMap;
    }

    public void setNotesMap(Map<LocalDate, List<String>> notesMap) {
        this.notesMap = notesMap;
    }
}
