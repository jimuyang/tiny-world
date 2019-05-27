package muyi.tiny.pylon.core.config;

import lombok.Data;

import java.util.List;

/**
 * @author: Yang Fan
 * @date: 2019-05-26
 * @desc: 作为一个pylon使用方 需要的所有配置
 */
@Data
public class SOAConf {

    private ServerConf serverConf;

    private List<ClientConf> clientConfList;


}
