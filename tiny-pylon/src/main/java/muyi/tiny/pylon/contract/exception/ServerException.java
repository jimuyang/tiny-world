package muyi.tiny.pylon.contract.exception;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public class ServerException extends Exception {
    private String code;

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String code, String message) {
        this(message);
        setCode(code);
    }

    public ServerException(String code, String message, Throwable cause) {
        super(message, cause);
        setCode(code);
    }

    public ServerException(String code, Throwable cause) {
        super(cause);
        setCode(code);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
