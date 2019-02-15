package com.components;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NotesMap {
    Map<LocalDate, List<String>> notes = new HashMap();
    void updateTable(LocalDate date, int number);
}
