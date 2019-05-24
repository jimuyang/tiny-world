package muyi.tiny.netty.executor;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yang Fan
 * @date: 2019-05-19
 * @desc: provide EventExecutor
 */
public interface EventExecutorGroup extends ScheduledExecutorService, Iterable<EventExecutor> {

    EventExecutor next();


    /**
     * use netty Future
     */

    @Override
    Future<?> submit(Runnable task);

    @Override
    <T> Future<T> submit(Runnable task, T result);

    @Override
    <T> Future<T> submit(Callable<T> task);

    @Override
    ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);

    @Override
    <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit);

    @Override
    ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);

    @Override
    ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);
}
