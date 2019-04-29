package synchronizedtest.moreobjectmorelock;

/**
 * describe 执行线程
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Run.java
 * @createTime 2019年04月29日 14:02:00
 */
public class Run {

    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum1 = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNum2 = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(hasSelfPrivateNum1);
        threadA.start();

        ThreadB threadB = new ThreadB(hasSelfPrivateNum2);
        threadB.start();
    }
}
