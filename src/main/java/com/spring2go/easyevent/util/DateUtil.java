package com.spring2go.easyevent.util;

/**
 * @author: Christy Guo
 * @create_date: 2023-05-02 11:22 PM
 * @desc:
 * @modifier:
 */

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

@Slf4j
public class DateUtil {
    public static String formatDateInISOString(Date date) {
        return date.toInstant().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
    }

    // https://stackoverflow.com/questions/2201925/converting-iso-8601-compliant-string-to-java-util-date
    public static Date convertISOStringToDate(String isoDateString) {
        TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(isoDateString);
        Instant i = Instant.from(ta);
        Date d = Date.from(i);
        return d;
    }
}
