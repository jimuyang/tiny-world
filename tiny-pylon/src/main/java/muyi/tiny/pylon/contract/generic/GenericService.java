package muyi.tiny.pylon.contract.generic;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public interface GenericService {
    Object invoke(String method, String[] paramTypes, String[] paramNames, Object[] args) throws Throwable;

}
