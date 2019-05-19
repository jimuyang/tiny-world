package muyi.tiny.spring.exception;


/**
 * @author: Yang Fan
 * @date: 2019-05-16
 * @desc:
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
