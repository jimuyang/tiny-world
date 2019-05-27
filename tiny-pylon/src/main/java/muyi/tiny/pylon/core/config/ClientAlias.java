package muyi.tiny.pylon.core.config;

import lombok.Data;
import muyi.tiny.pylon.contract.client.ClientAttrs;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
@Data
public class ClientAlias {

    private ClientConf conf;
    private Class<?> iface;
    private ClientAttrs attrs;

}
