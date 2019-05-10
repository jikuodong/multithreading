package readwritelock;

/**
 * describe 测试读写互斥
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ReadWriteLockTest.java
 * @createTime 2019年05月06日 11:58:00
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        final ReadWriteLock readWriteLock = new ReadWriteLock();

        Thread threadA = new Thread() {
            @Override
            public void run() {
                readWriteLock.read();
            }
        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                readWriteLock.write();
            }
        };
        threadA.start();
        threadB.start();
    }
}
