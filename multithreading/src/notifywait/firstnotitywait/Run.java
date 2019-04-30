package notifywait.firstnotitywait;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Run.java
 * @createTime 2019年04月30日 09:37:00
 */
public class Run {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
