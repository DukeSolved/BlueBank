package com.ibm.bluebank.shared.dates.converter;

import com.ibm.bluebank.shared.dates.exceptions.DateParseException;
import com.ibm.bluebank.shared.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class DataConverter {

    private static String DATE_FORMAT = "yyyy-MM-dd";

    public Date toDate(String referencia, String toDate, Map<String, String> erros) {
        Date data = null;
        try {
            data = DateUtil.toDate(toDate, DATE_FORMAT);
            return data;
        } catch (DateParseException e) {
            erros.put(referencia, e.getMessage());
        }
        return data;
    }

}
