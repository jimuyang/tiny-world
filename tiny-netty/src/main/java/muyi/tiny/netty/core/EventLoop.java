package muyi.tiny.netty.core;

import muyi.tiny.netty.executor.EventExecutor;

/**
 * @author: Yang Fan
 * @date: 2019-05-19
 * @desc:
 */
public interface EventLoop extends EventExecutor, EventLoopGroup {

    @Override
    EventLoopGroup parent();
}

