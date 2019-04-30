package lockdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * describe ReentrantLock和synchronized关键字一样可以用来实现线程之间的同步互斥，
 * 但是在功能是比synchronized关键字更强大而且更灵活。
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ReentrantLockTest.java
 * @createTime 2019年04月30日 15:38:00
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        MyService service = new MyService();

        MyThread a1 = new MyThread(service);
        MyThread a2 = new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();

    }

    static public class MyService {
        private Lock lock = new ReentrantLock();

        public void testMethod() {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" +Thread.currentThread().getName()+(" "+(i+1)));
                }
            } finally {
                lock.unlock();
            }
        }
    }

    static public class MyThread extends Thread {
        private MyService service;

        public MyThread(MyService service) {
            super();
            this.service = service;
        }
        @Override
        public void run() {
            service.testMethod();
        }
    }
}
