package muyi.tiny.pylon.core.config;

import lombok.Data;

import java.util.List;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc: Q配置
 */
@Data
public class QueueConf {

    private String username;
    private String password;
    private String virtualHost;
    private String exchangeName;
    private String routingKey;
    private List<String> urls;
    private String queueName;
    private boolean mandatory;
    private boolean durable;

//    public MsgQueueConf convert() {
//        MsgQueueConf conf = new MsgQueueConf();
//        conf.setExchangeName(exchangeName);
//        conf.setPassword(password);
//        conf.setUsername(username);
//        conf.setVirtualHost(virtualHost);
//        conf.setRoutingKey(routingKey);
//        conf.setUrls(urls);
//        conf.setQueueName(queueName);
//        conf.setMandatory(mandatory);
//        conf.setDurable(durable);
//        return conf;
//    }
}
