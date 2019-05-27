package muyi.tiny.pylon.contract.iface;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public interface ServiceInitializer {
    default void init() {
    }

    default Object getImpl(Class<?> iface) {
        return null;
    }

    default InvokeHandler getHandler(Class<?> iface) {
        return null;
    }

    default AuthStrategy getAuthStrategy() {
        return new AuthStrategy() {
        };
    }

//    default IServiceChecker getChecker() {
//        return new IServiceChecker() {
//        };
//    }
//
//    default IServiceDumper getDumper() {
//        return new IServiceDumper() {
//        };
//    }

}
