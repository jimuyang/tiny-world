package muyi.tiny.spring.util;

/**
 * @author: Yang Fan
 * @date: 2019-05-12
 * @desc:
 */
public class Assert {

    public static void notEmpty(String str, String message) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }


}
