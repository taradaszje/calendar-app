package com.components;

import java.time.LocalDate;

public interface NotesService {
    void addNote(LocalDate date, String note);
}
