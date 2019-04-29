package createThread;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ImplementsThread.java
 * @createTime 2019年04月28日 13:55:00
 */
public class ImplementsThread implements Runnable{
    private String name;
    public ImplementsThread (String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name+"运行："+i);
            try {
                Thread.sleep((long) (Math.random()+10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ImplementsThread("C")).start();
        new Thread(new ImplementsThread("D")).start();
    }
}
