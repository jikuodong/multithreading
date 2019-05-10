package practice.producerconsumer;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Consumer.java
 * @createTime 2019年05月10日 13:59:00
 */
public class Consumer implements Runnable {
    private Stack<Character> stack;

    public Consumer(Stack<Character> stack) {
        this.stack = stack;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 消费者弹出： " + stack.pull()+ " 任务数量="+stack.getSize());
        }
    }
}
