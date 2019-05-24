package muyi.tiny.netty.executor;

import io.netty.util.concurrent.*;
import muyi.tiny.netty.core.EventExecutorChooserFactory;

import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Yang Fan
 * @date: 2019-05-19
 * @desc: 多线程执行器组
 */
public abstract class MultithreadEventExecutorGroup extends AbstractEventExecutorGroup {

    private final EventExecutor[] children;

    private final EventExecutorChooserFactory.EventExecutorChooser chooser;

    private final AtomicInteger terminatedChildren = new AtomicInteger();

    private final Promise<?> terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);

//    private final Set<EventExecutor> readonlyChildren;

    protected abstract EventExecutor newChild(Executor executor, Object... args) throws Exception;


    protected MultithreadEventExecutorGroup(int nThreads, Executor executor,
                                            EventExecutorChooserFactory chooserFactory, Object... args) {
        if (nThreads <= 0) {
            throw new IllegalArgumentException(String.format("nThreads: %d (expected: > 0)", nThreads));
        }

        if (executor == null) {
            executor = new ThreadPerTaskExecutor(new DefaultThreadFactory(getClass()));
        }

        children = new EventExecutor[nThreads];

        for (int i = 0; i < nThreads; i++) {
//            boolean success = false;
            try {
                children[i] = newChild(executor, args);
//                success = true;
            } catch (Exception e) {
                throw new IllegalStateException("failed to create a child event loop", e);
            }
        }

        chooser = chooserFactory.newChooser(children);

        final FutureListener<Object> terminationListener = (future -> {
            if (terminatedChildren.incrementAndGet() == children.length) {
            }
        });


    }

}
