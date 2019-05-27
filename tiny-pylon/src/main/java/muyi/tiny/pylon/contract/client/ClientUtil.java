package muyi.tiny.pylon.contract.client;


/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public class ClientUtil {

    private static ClientContext context;

    public static ClientContext getContext() {
        if (context == null) {
            try {
                context = (ClientContext) Class.forName("").newInstance();
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }
        return context;
    }
}
