package muyi.tiny.spring.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Yang Fan
 * @date: 2019-05-10
 * @desc:
 */
public class SimpleAliasRegistry implements AliasRegistry {

    /**
     * <alias, name>
     */
    private final Map<String, String> aliasMap = new ConcurrentHashMap<>(16);

    @Override
    public void registerAlias(String name, String alias) {
        this.aliasMap.put(alias, name);
    }

    @Override
    public void removeAlias(String alias) {
        this.aliasMap.remove(alias);
    }

    @Override
    public boolean isAlias(String name) {
        return this.aliasMap.containsKey(name);
    }

    @Override
    public String[] getAliases(String name) {
        List<String> result = new ArrayList<>();
        //todo
        return null;
    }

    /**
     * alias是不是name的alias
     */
    public boolean hasAlias(String name, String alias) {
        for (Map.Entry<String, String> entry : this.aliasMap.entrySet()) {
            String existName = entry.getValue();
            if (existName.equals(name)) {
                String existAlias = entry.getKey();
                if (existAlias.equals(alias) || hasAlias(existAlias, alias)) {
                    return true;
                }
            }

        }
        return false;
    }


}
