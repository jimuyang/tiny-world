package muyi.tiny.pylon.core.config;

import lombok.Data;
import muyi.tiny.pylon.contract.iface.ServiceInitializer;

import java.util.List;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc: pylon server配置
 */
@Data
public class ServerConf {

    private String protocol;
    private String group;
    private boolean compress;
    private int port;
    private int workerGroupSize;
    private int threadPoolSize;
    private int bufferQueueSize;
    private long exitDelayInMillis;
    private boolean validatable;
    private ServiceInitializer initializer;
    private List<Class<?>> interfaces;
    private List<Class<?>> filterList;

    private QueueConf queue;
}
