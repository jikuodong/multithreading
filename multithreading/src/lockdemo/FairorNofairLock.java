package lockdemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * describe 公平锁与非公平锁
 * Lock锁分为： 公平锁和非公平锁。
 * 公平锁：表示线程获取锁的顺序是按照线程加锁的顺序来分配的，即先来的FIFO先进先出顺序。
 * 非公平锁：是一种获取锁的抢占机制，是随机获取锁的，和公平锁不一样的就是先来的不一定先得到锁，这样可能造成某些线程一直拿不到锁，结果也就是不公平的了。
 * @author JKD
 * @version 1.0.0
 * @ClassName FairorNofairLock.java
 * @createTime 2019年05月06日 09:54:00
 */
public class FairorNofairLock {

    public static void main(String[] args) {
        // true为公平锁，false为非公平锁
        final Service service = new Service(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("★线程" + Thread.currentThread().getName()+ "运行了");
                service.serviceMethod();
            }
        };

        Thread[] threadArray = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }

    }
    static public class Service {
        private ReentrantLock lock;

        public Service(boolean isFair) {
            super();
            lock = new ReentrantLock(isFair);
        }
        public void serviceMethod() {
            try {
                lock.lock();
                System.out.println("线程名称="+Thread.currentThread().getName()+ "获得锁定");
            } finally {
                lock.unlock();
            }
        }
    }
}
