package com.ibm.bluebank.shared.dates.converter;

import com.ibm.bluebank.shared.dates.exceptions.DateParseException;
import com.ibm.bluebank.shared.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DataConverter {

    public Date toDate(String toDate) {
        Date date = null;
        try {
            date = DateUtil.toDate(toDate);
        } catch (DateParseException e) {
        }
        return date;
    }

    public String toString(Date date) {
        return DateUtil.toString(date);
    }

}
