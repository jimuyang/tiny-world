package muyi.tiny.pylon.rpc;


/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public enum CallStatus {

    /**
     * 非业务异常
     */
    CRIT,
    /**
     * 业务异常
     */
    BIZ,
    /**
     * 超时
     */
    TIMEOUT,
    /**
     * 熔断
     */
    SICK,
    /**
     * 软超时
     */
    SOFT_TIMEOUT,
    /**
     * 降级
     */
    DOWN,
    /**
     * 授权不通过
     */
    NO_AUTHORITY,
    /**
     * 超出并发
     */
    NO_AVAILABLE_THREAD,
    /**
     * 验签失败
     */
    SIGNATURE_FAILED;


}
