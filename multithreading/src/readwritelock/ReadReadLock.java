package readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * describe 读读共享
 *
 * 两个线程同时运行read方法，会发现两个线程可以同时或者说是几乎同时运行lock()方法后面的代码
 * 输出的两句话的显示的时间一样。这样提高了程序运行效率。
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ReadReadLock.java
 * @createTime 2019年05月06日 11:05:00
 */
public class ReadReadLock {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            try {
                lock.readLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(1000);
            } finally {
                lock.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
