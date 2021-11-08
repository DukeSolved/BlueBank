package com.ibm.bluebank.shared.utils;

import com.ibm.bluebank.shared.dates.exceptions.DateParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String DATE_FORMAT = "yyyy-MM-dd";

    public static Date toDate(String toParse) throws DateParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Date data = null;
        try {
            data = sdf.parse(toParse);
        } catch (ParseException e) {
            throw new DateParseException(DATE_FORMAT);
        }
        return data;
    }

    public static String toString(Date toString) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String parsed = sdf.format(toString);
        return parsed;
    }
}
