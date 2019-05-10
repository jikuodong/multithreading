package readwritelock;

/**
 * describe 测试读读共享
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ReadReadLockTest.java
 * @createTime 2019年05月06日 11:11:00
 */
public class ReadReadLockTest {
    public static void main(String[] args) {
        final ReadReadLock readReadLock = new ReadReadLock();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程1");
                readReadLock.read();
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程2");
                readReadLock.read();
            }
        };
        thread1.start();
        thread2.start();
    }
}
