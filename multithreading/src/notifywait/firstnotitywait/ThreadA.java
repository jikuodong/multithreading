package notifywait.firstnotitywait;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ThreadA.java
 * @createTime 2019年04月30日 09:24:00
 */
public class ThreadA extends Thread{
    private final Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin"+System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end" + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
