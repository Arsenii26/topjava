package ru.javawebinar.topjava.util;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";

    //Formatter for printing and parsing date-time objects.
    //This class provides the main application entry point for printing and parsing and provides common implementations of DateTimeFormatter:
    //
    //Using predefined constants, such as ISO_LOCAL_DATE
    //Using pattern letters, such as uuuu-MMM-dd
    //Using localized styles, such as long or medium
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    // DataBase doesn't support LocalDate.MIN/MAX
    private static final LocalDate MIN_DATE = LocalDate.of(1, 1, 1);
    private static final LocalDate MAX_DATE = LocalDate.of(3000, 1, 1);

    private DateTimeUtil() {
    }

    public static LocalDateTime adjustStartDateTime(LocalDate localDate) {
        return adjustDateTime(localDate, MIN_DATE, LocalTime.MIN);
    }

    public static LocalDateTime adjustEndDateTime(LocalDate localDate) {
        return adjustDateTime(localDate, MAX_DATE, LocalTime.MAX);
    }

    private static LocalDateTime adjustDateTime(LocalDate localDate, LocalDate defaultDate, LocalTime adjustTime) {
        return LocalDateTime.of(localDate != null ? localDate : defaultDate, adjustTime);
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }

    public static LocalDate parseLocalDate(@Nullable String str) {
        return StringUtils.isEmpty(str) ? null : LocalDate.parse(str);
    }

    public static LocalTime parseLocalTime(@Nullable String str) {
        return StringUtils.isEmpty(str) ? null : LocalTime.parse(str);
    }
}