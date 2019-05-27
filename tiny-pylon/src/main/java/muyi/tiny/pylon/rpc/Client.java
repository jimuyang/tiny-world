package muyi.tiny.pylon.rpc;

import lombok.Data;
import muyi.tiny.pylon.contract.iface.ServiceDumper;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
@Data
public abstract class Client<B extends ServiceDumper> implements ServiceDumper {

    private final String name;

    private final String group;

//    private final


}
