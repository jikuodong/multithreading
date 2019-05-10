package practice.producerconsumer;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Test.java
 * @createTime 2019年05月10日 14:06:00
 */
public class Test {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < 3; ++i) {
            new Thread(new Producer((stack))).start();
        }

        for (int i = 0; i< 3; ++i) {
            new Thread((new Consumer(stack))).start();
        }
    }

}
