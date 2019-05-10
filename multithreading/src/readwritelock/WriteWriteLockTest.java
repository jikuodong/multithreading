package readwritelock;

/**
 * describe 测试写写互斥
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName WriteWriteLockTest.java
 * @createTime 2019年05月06日 11:44:00
 */
public class WriteWriteLockTest {
    public static void main(String[] args) {
        final WriteWriteLock writeWriteLock = new WriteWriteLock();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    System.out.println("线程"+ Thread.currentThread().getName());
                    writeWriteLock.read();
                }
            };
            thread.start();
        }
    }
}
