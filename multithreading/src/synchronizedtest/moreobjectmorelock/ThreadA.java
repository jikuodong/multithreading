package synchronizedtest.moreobjectmorelock;

/**
 * describe 线程A
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ThreadA.java
 * @createTime 2019年04月29日 13:58:00
 */
public class ThreadA extends Thread{

    private HasSelfPrivateNum hasSelfPrivateNum;

    public ThreadA(HasSelfPrivateNum hasSelfPrivateNum) {
        super();
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        super.run();
        hasSelfPrivateNum.addI("a");
    }
}
