package muyi.tiny.netty.executor;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.ProgressivePromise;
import io.netty.util.concurrent.Promise;

/**
 * @author: Yang Fan
 * @date: 2019-05-19
 * @desc:
 */
public interface EventExecutor extends EventExecutorGroup {

    EventExecutorGroup parent();

    boolean inEventLoop();

    boolean inEventLoop(Thread thread);


    <V> Promise<V> newPromise();

    <V> ProgressivePromise<V> newProgressivePromise();

    <V> Future<V> newSucceededFuture(V result);

    <V> Future<V> newFailedFuture(Throwable cause);

}
