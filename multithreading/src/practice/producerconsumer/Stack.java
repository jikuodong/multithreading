package practice.producerconsumer;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * describe
 * 需求：1、用栈来存取数据，设置当栈内为空时，pull等待，当栈内有200条数据时，push等待
 *  *      2、提供一个生产者线程类（ProducerThread），生产随机大写字符压入栈内
 *  *      3、提供一个消费者线程类（Consumer Thread），从栈中弹出字符，并打印
 *  *      4、提供一个测试类，使2个生产者和3个消费者线程同时运行
 *  *  注意：生产者、消费者线程需要不停的执行，必须在run方法中用一个while(true)循环，wait、notify方法必须放在synchronized块
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Stack.java
 * @createTime 2019年05月10日 13:27:00
 */
public class Stack<T> {

    private LinkedList<T> list;
    private int count;

    public Stack() {
        list = new LinkedList<>();
        count = 0;
    }

    public synchronized  int getSize() {
        return count;
    }

    public  synchronized  void push(T ele) {
        while (count >= 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.offerLast(ele);
        count++;
        this.notifyAll();
    }

    public synchronized T pull() {
        while (count <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T res = list.pollLast();
        count--;
        this.notifyAll();
        return res;
    }
    public synchronized  T peek() {
        return list.peekLast();
    }

}
