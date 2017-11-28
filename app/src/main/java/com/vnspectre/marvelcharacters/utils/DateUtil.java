package com.vnspectre.marvelcharacters.utils;

/**
 * Created by Spectre on 11/28/17.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static String parseDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
        return format.format(date);
    }
}
