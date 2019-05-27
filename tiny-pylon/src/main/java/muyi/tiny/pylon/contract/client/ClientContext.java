package muyi.tiny.pylon.contract.client;

import muyi.tiny.pylon.contract.generic.GenericService;

import java.util.List;
import java.util.Map;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc:
 */
public interface ClientContext {

    void initClients();

    void initClients(String path);

    <T> T getClient(Class<T> clazz);

    <T> T getClient(Class<T> clazz, Map<String, Object> metas);

    <T> T getClient(Class<T> clazz, ClientAttrs clientAttrs);

    <T> T getClient(String name, Class<T> clazz);

    <T> T getClient(String name, Class<T> clazz, Map<String, Object> metas);

    <T> T getClient(String name, Class<T> clazz, ClientAttrs clientAttrs);

    <T> T getClient(String name, String group, Class<T> clazz);

    <T> T getClient(String name, String group, Class<T> clazz, Map<String, Object> metas);

    <T> T getClient(String name, String group, Class<T> clazz, ClientAttrs clientAttrs);

    <T> T getClientByAlias(String alias, Class<T> clazz);

    <T> T getClientByAlias(String alias, Class<T> clazz, ClientAttrs clientAttrs);

    <T> T getClientByAlias(String alias, Class<T> clazz, Map<String, Object> metas);

    <T> List<T> getClients(Class<T> clazz);

    <T> List<T> getClients(Class<T> clazz, ClientAttrs clientAttrs);

    <T> List<T> getClients(String name, Class<T> clazz);

    <T> List<T> getClients(String name, Class<T> clazz, ClientAttrs clientAttrs);

    <T> List<T> getClients(String name, String group, Class<T> clazz);

    <T> List<T> getClients(String name, String group, Class<T> clazz, ClientAttrs clientAttrs);

    <T> List<T> getClientsByAlias(String alias, Class<T> clazz);

    <T> List<T> getClientsByAlias(String alias, Class<T> clazz, ClientAttrs clientAttrs);

    GenericService getGenericService(String iface);

    GenericService getGenericService(String iface, ClientAttrs clientAttrs);

    GenericService getGenericService(String iface, Map<String, Object> metas);

    GenericService getGenericService(String name, String iface);

    GenericService getGenericService(String name, String iface, Map<String, Object> metas);

    GenericService getGenericService(String name, String iface, ClientAttrs clientAttrs);

    GenericService getGenericService(String name, String group, String iface);

    GenericService getGenericService(String name, String group, String iface, Map<String, Object> metas);

    GenericService getGenericService(String name, String group, String iface, ClientAttrs clientAttrs);


}

