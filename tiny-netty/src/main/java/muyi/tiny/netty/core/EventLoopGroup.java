package muyi.tiny.netty.core;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import muyi.tiny.netty.executor.EventExecutorGroup;

/**
 * @author: Yang Fan
 * @date: 2019-05-19
 * @desc:
 */
public interface EventLoopGroup extends EventExecutorGroup {

    @Override
    EventLoop next();

    ChannelFuture register(Channel channel);

    ChannelFuture register(ChannelPromise promise);


}
