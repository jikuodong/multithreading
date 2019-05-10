package readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * describe 写写互斥
 *
 * 两个线程同时运行read方法，你会发现同一时间只允许一个线程执行lock()方法后面的代码。
 * @author JKD
 * @version 1.0.0
 * @ClassName WriteWriteLock.java
 * @createTime 2019年05月06日 11:35:00
 */
public class WriteWriteLock {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            try {
                lock.writeLock().lock();
                System.out.println("获得写锁"+Thread.currentThread().getName()+ " "+System.currentTimeMillis());
                Thread.sleep(1000);
            } finally {
                lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
