package muyi.tiny.pylon.core.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc: soa client 声明要调用的服务以及调用的方式
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"name", "group"})
public class ClientConf {

    /**
     * appId
     */
    private String name;

    /**
     * huskar group
     */
    private String group;

    /**
     * json/thrift
     */
    private String protocol;

    private String compress;

    private boolean generic;

    private boolean callHSF;

    /**
     * 线程池大小
     */
    private int threadPoolSize;

    /**
     * 所有接口超时配置
     */
    private int timeoutInMillis;

    /**
     * 负载均衡策略 默认round-robin
     */
    private String lbStrategy;

    /**
     * 线程池策略 semaphore(线程池满时抛出异常)／queue(线程池满时排队等待执行)
     */
    private String tpStrategy;

    private List<Class<?>> interfaces;
    private List<String> genericIfaces;
    private List<Class<?>> fallbacks;

    /**
     * 固定的url列表 不选择使用huskar作为注册中心时
     */
    private List<String> providerList;
    private List<Class<?>> filterList;

    public ClientConf(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public void setProtocol(String protocol) {
        //convert protocol hsf json to json and set call hsf
        if (protocol.equalsIgnoreCase("hsfjson")) {
            this.protocol = "json";
            this.callHSF = true;
        } else {
            this.protocol = protocol;
        }
    }
}
