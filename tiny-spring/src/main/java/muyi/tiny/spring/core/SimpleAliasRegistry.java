package muyi.tiny.spring.core;

import muyi.tiny.spring.util.Assert;

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
        Assert.notEmpty(name, "'name' cannot be empty");
        Assert.notEmpty(alias, "'alias' cannot be empty");

        // 对于正常的ConcurrentHashMap是不需要加锁的 但这里可能出现 alias chain
        synchronized (this.aliasMap) {
            if (alias.equals(name)) {
                // alias和name一样
                // do nothing
            } else {
                // 默认直接写入
                checkCircleAlias(name, alias);
                this.aliasMap.put(alias, name);
            }

        }
//        this.aliasMap.put(alias, name);
    }

    @Override
    public void removeAlias(String alias) {
        synchronized (this.aliasMap) {
            this.aliasMap.remove(alias);
        }
    }

    @Override
    public boolean isAlias(String name) {
        // 不需要上锁
        return this.aliasMap.containsKey(name);
    }

    @Override
    public String[] getAliases(String name) {
        List<String> result = new ArrayList<>();
        synchronized (this.aliasMap) {
            retrieveAliases(name, result);
        }
        return result.toArray(new String[0]);
    }

    public String canonicalName(String name) {
        String canonicalName;
        while (true) {
            canonicalName = this.aliasMap.get(name);
            if (canonicalName == null) {
                return name;
            }
            name = canonicalName;
        }
    }


    /**
     * alias是不是name的alias
     */
    private boolean hasAlias(String name, String alias) {
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

    private void checkCircleAlias(String name, String alias) {
        if (hasAlias(alias, name))
            throw new IllegalStateException("Cannot register alias '" + alias +
                    "' for name '" + name + "': Circular reference - '" +
                    name + "' is a direct or indirect alias for '" + alias + "' already");
    }

    /**
     * 取得name的所有alias
     */
    private void retrieveAliases(String name, List<String> result) {
        this.aliasMap.forEach((alias, existName) -> {
            // 递归去找 alias chain
            if (existName.equals(name)) {
                result.add(alias);
                retrieveAliases(alias, result);
            }
        });
    }


}
