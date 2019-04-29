package dirtyreading;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ThreadA.java
 * @createTime 2019年04月29日 14:40:00
 */
public class ThreadA extends Thread {
    private PublicVar publicVar;

    public ThreadA(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B","BB");
    }
}
