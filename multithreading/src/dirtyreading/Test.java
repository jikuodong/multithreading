package dirtyreading;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Test.java
 * @createTime 2019年04月29日 14:43:00
 */
public class Test {
    public static void main(String[] args) {
        try {
            PublicVar publicVar = new PublicVar();
            ThreadA threadA = new ThreadA(publicVar);
            threadA.start();
            // 打印结果受此值大小影响
            Thread.sleep(200);
            publicVar.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
