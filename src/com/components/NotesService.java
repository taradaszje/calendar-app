package com.components;

import java.time.LocalDate;
import java.util.List;

public interface NotesService {
    void addNote(LocalDate date, String note);

    void removeNote(LocalDate date);

    List<String> getNote(LocalDate date);
}
