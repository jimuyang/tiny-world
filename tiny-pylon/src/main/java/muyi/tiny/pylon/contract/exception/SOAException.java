package muyi.tiny.pylon.contract.exception;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public class SOAException extends SystemException {

    private final static String code = "SOA";

    public SOAException(String message) {
        super(code, message);
    }

    public SOAException(String message, Throwable cause) {
        super(code, message, cause);
    }

    public SOAException(Throwable cause) {
        super(code, cause);
    }
}
