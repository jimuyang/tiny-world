package muyi.tiny.pylon.contract.iface;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public interface ServiceDumper {


    @SuppressWarnings("unchecked")
    static Map<String, Object> dumpInfo(ServiceDumper dumper) {
        if (dumper == null) {
            return null;
        } else if (dumper.dumpInfo() != null && dumper.dumpInfo() instanceof Map) {
            return (Map<String, Object>) dumper.dumpInfo();
        } else {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("meta", dumper.dumpInfo());
            return map;
        }
    }

    default Object dumpInfo() {
        return null;
    }


}
