package synchronizedtest.moreobjectmorelock;

/**
 * describe  执行的任务
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName HasSelfPrivateNum.java
 * @createTime 2019年04月29日 13:46:00
 */
public class HasSelfPrivateNum {

    private int num = 0;

    synchronized public void addI(String userName) {
        try {
            if (("a").equals(userName)) {
                num = 100;
                System.out.println("a 结束!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b 结束！");
            }
            System.out.println(userName+"num=" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
