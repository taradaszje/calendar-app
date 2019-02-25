package com.components;

import java.time.LocalDate;

public interface NoteObserver {
    void viewNote(LocalDate date);
}
