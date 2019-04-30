package lockdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName MyserviceMoreCondition.java
 * @createTime 2019年04月30日 17:23:00
 */
public class MyserviceMoreCondition {
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA() {
        lock.lock();
        try {
            System.out.println("begin awaitA时间为"+System.currentTimeMillis()+ "ThreadName="+Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA时间为"+ System.currentTimeMillis()+"ThreadName="+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        lock.lock();
        try {
            System.out.println("begin awaitB时间为" + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("  end awaitB时间为" + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        lock.lock();
        try {
            System.out.println("signaAll_A时间为"+System.currentTimeMillis()+"ThreadName="+Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        lock.lock();
        try {
            System.out.println("signaAll_B时间为"+System.currentTimeMillis()+"ThreadName="+Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }

    }

}
