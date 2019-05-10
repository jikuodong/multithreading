package readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * describe 读写互斥
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ReadWriteLock.java
 * @createTime 2019年05月06日 11:51:00
 */
public class ReadWriteLock {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            try {
                lock.readLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName()+" "+System.currentTimeMillis());
                Thread.sleep(1000);
            } finally {
                lock.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            try {
                lock.writeLock().lock();
                System.out.println("获得写锁" + Thread.currentThread().getName()+ " " + System.currentTimeMillis());
                Thread.sleep(1000);
            } finally {
                lock.writeLock().lock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
