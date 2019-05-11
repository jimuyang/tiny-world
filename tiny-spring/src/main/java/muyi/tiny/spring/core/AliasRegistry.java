package muyi.tiny.spring.core;

/**
 * @author: Yang Fan
 * @date: 2019-05-10
 * @desc: alias注册
 */
public interface AliasRegistry {

    void registerAlias(String name, String alias);

    void removeAlias(String alias);

    boolean isAlias(String name);

    String[] getAliases(String name);

}
