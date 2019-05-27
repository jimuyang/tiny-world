package muyi.tiny.pylon.contract.iface;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public interface AuthStrategy {

    default boolean isAllowed(String client, Method method, Map<String, Object> args, Map<String, Object> metas) {
        return true;
    }
}
