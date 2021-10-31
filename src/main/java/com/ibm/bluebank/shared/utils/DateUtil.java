package com.ibm.bluebank.shared.utils;

import com.ibm.bluebank.shared.dates.exceptions.DateParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date toDate(String toParse, String pattern) throws DateParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date data = null;
        try {
            data = sdf.parse(toParse);
        } catch (ParseException e) {
            throw new DateParseException(pattern);
        }
        return data;
    }

    public static String toString(Date toString, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String parsed = sdf.format(toString);
        return parsed;
    }
}
