package muyi.tiny.pylon.contract.client;

import lombok.Data;

import java.util.Map;

/**
 * @author: Yang Fan
 * @date: 2019-05-24
 * @desc:
 */
@Data
public class ClientAttrs implements Cloneable {

    private Map<String, Object> metas;

    private long timeoutInMillis;

    private String url;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
