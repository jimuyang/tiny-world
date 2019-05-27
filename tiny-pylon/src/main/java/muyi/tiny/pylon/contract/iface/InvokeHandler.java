package muyi.tiny.pylon.contract.iface;

import muyi.tiny.pylon.contract.exception.ServerException;
import muyi.tiny.pylon.contract.exception.ServiceException;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public interface InvokeHandler {
    /**
     * This method should be able to handle every method of an interface.
     *
     * @param method the {@link Method} which is being invoked.
     * @param args   parameters in a {@link Map}, parameter name as key, parameter {@link Object} as value
     * @param metas  metas in a {@link Map}, meta name as key, meta {@link Object} as value
     * @return the result {@link Object}
     * @throws ServiceException thrown if an exception occurs. This exception will be transferred to the RPC client.
     */
    Object invoke(Method method, Map<String, Object> args, Map<String, Object> metas) throws ServiceException, ServerException;
}
