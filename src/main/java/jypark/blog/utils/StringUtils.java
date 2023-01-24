package jypark.blog.utils;

public class StringUtils {

    /**
     * 메인 리스트에서 사용하는 리스트의 컨텐츠 일부 글을 편집해준다.
     * @param str
     * @return
     */
    public static String summarize(String str) {
        if(isBlank(str)) {
            return "";
        }

        if(str.length() > 100) {
            return str.substring(0, 100) + "...";
        }
        return str;
    }

    /**
     * title 을 축약어로 변경합니다. (25자 기준)
     * @param title
     * @return
     */
    public static String abbreviate(String title) {
        if(isBlank(title)) {
            return "";
        }

        if(title.length() > 25) {
            return title.substring(0, 25) + "⋯";
        }

        return title;
    }

    public static boolean isBlank(String str) {
        if(str == null) {
            return true;
        }
        if(str.replaceAll(" ", "").equals("")) {
            return true;
        }

        return false;
    }

    /**
     * str 값이 blank 인 경우 대체값으로 리턴
     * @param str
     * @param defaultValue
     * @return
     */
    public static String isBlankOrElse(String str, String defaultValue) {
        return isBlank(str) ? defaultValue : str;
    }

    public static boolean isFavicon(String str) {
        return str.equals("favicon.ico");
    }
}
