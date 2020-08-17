package com.example.libraryapi.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);


    // "08/15/2020"
    public static Date convertStringToDate(String dateString) {
        Date date = new Date();
        try {
            date = DATE_FORMAT.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String convertDateToString(Date date)
    {
        return DATE_FORMAT.format(date);
    }

}
