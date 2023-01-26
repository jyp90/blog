package jypark.blog.utils;

import java.text.DecimalFormat;

public class DecimalFormatUtils {

    public static String toDecimalFormat(long value) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(value);
    }

}
