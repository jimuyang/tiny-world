package muyi.tiny.spring.util;

/**
 * @author: Yang Fan
 * @date: 2019-05-15
 * @desc:
 */
public class StringUtil {

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0 || string.trim().length() == 0;
    }

    public static boolean notEmpty(String string) {
        return !isEmpty(string);
    }
}
