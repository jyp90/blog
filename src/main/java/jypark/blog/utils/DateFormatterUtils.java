package jypark.blog.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterUtils {

    public static final DateTimeFormatter CREATED_AT = DateTimeFormatter.ofPattern("yyyy. M. d. HH:mm");

    public static String toCreatedAt(LocalDateTime time) {
        if(time == null) {
            return "";
        }
        return time.format(CREATED_AT);
    }
}
