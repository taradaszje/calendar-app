package com.components;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtility {
    private static final String PATTERN = "yyyy-MM-dd";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);

    private DateUtility() {
    }

    public static LocalDate stringToDate(String dateString) {
        return LocalDate.parse(dateString, formatter);
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }
}
