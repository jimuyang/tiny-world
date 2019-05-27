package muyi.tiny.pylon.rpc;

import java.lang.reflect.Method;
import java.util.concurrent.Future;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public interface Task {

    Method getMethod();

    String getIfaceName();

    String getMethodName();

    long getTimeoutInMillis();

    CallStatus getCallStatus();

    boolean supportFallBack();

    Object callFallback() throws Exception;

    void cancel();

    Future<Object> nioCall();

    String getApi();


}
