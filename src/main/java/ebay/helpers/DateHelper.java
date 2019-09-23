package ebay.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyyMMddHHmmss";

    public static DateTimeFormatter getFormatterForTheDateWithDateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD_HH_MM_SS);
        return formatter;
    }

    public static String getCurrentDateTimeFormatted() {
        return LocalDateTime.now().format(getFormatterForTheDateWithDateAndTime());
    }

}
