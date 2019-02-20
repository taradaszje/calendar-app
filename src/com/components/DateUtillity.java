package com.components;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtillity {
    private static final String PATTERN ="yyyy-MM-dd";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
    private DateUtillity(){ }

    public static LocalDate stringToDate(String dateString) { ;
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }
}
