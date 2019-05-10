package practice.producerconsumer;

import java.util.Random;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Producer.java
 * @createTime 2019年05月10日 13:53:00
 */
public class Producer implements Runnable {

    private Stack<Character> stack;
    public Producer(Stack<Character> stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            char c = generateChar();
            stack.push(c);
            System.out.println(Thread.currentThread().getName()+" 生产者加入: " + c + " 任务数量=" + stack.getSize());
        }
    }

    private char generateChar() {
        return (char)(new Random().nextInt(26)+'a');
    }
}
