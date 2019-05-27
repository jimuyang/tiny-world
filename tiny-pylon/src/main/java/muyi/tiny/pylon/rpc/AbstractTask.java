package muyi.tiny.pylon.rpc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Method;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
@RequiredArgsConstructor
@Getter
public abstract class AbstractTask implements Task {

    protected final Client client;

    protected final Class<?> iface;

    protected final Method method;

    protected final Object[] args;

    protected final String api;

    protected final long timeoutInMillis;

    protected final String requestString;

    protected final CallStatus callStatus;

    protected final String url;





}
