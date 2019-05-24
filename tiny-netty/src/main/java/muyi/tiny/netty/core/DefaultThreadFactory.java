//package muyi.tiny.netty.core;
//
//import io.netty.util.concurrent.FastThreadLocalThread;
//
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @author: Yang Fan
// * @date: 2019-05-19
// * @desc: 看下线程工厂的实现
// */
//public class DefaultThreadFactory implements ThreadFactory {
//
//    private static final AtomicInteger POOL_ID = new AtomicInteger();
//
//    private final AtomicInteger nextId = new AtomicInteger();
//
//    /**
//     * 前缀 poolName + poolId
//     */
//    private final String prefix;
//
//    /**
//     * 是否守护线程
//     */
//    private final boolean daemon;
//
//    /**
//     * 优先级 1-10 默认5
//     */
//    private final int priority;
//
//    protected final ThreadGroup threadGroup;
//
//
//    public DefaultThreadFactory(String poolName, boolean daemon, int priority, ThreadGroup threadGroup) {
//        if (poolName == null) {
//            throw new NullPointerException("poolName");
//        }
//
//        if (priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY) {
//            throw new IllegalArgumentException(
//                    "priority: " + priority + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
//        }
//
//        this.prefix = poolName + '-' + POOL_ID.incrementAndGet() + "-";
//        this.daemon = daemon;
//        this.priority = priority;
//        this.threadGroup = threadGroup;
//    }
//
//
//    @Override
//    public Thread newThread(Runnable r) {
//        Thread t = newThread(r, prefix + nextId.incrementAndGet());
//        try {
//            if (t.isDaemon() != daemon) {
//                t.setDaemon(daemon);
//            }
//
//            if (t.getPriority() != priority) {
//                t.setPriority(priority);
//            }
//        } catch (Exception ignored) {
//            // Doesn't matter even if failed to set.
//        }
//        return t;
//    }
//
//    protected Thread newThread(Runnable r, String name) {
//        return new FastThreadLocalThread(threadGroup, r, name);
//    }
//
//}
