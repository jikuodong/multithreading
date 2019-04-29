package createThread;

import com.sun.prism.util.tess.Tess;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ExtendsThread.java
 * @createTime 2019年04月28日 11:55:00
 */
public class ExtendsThread extends Thread {
    private String name;
    public ExtendsThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行："+i);
            try {
                Thread.sleep((int)(Math.random()+10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExtendsThread s1 = new ExtendsThread("A");
        ExtendsThread s2 = new ExtendsThread("B");
        s1.start();
        s2.start();
    }
}
