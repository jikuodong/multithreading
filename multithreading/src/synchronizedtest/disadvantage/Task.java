package synchronizedtest.disadvantage;

/**
 * describe 任务类
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Task.java
 * @createTime 2019年04月29日 15:37:00
 */
public class Task {
    private String getData1;
    private String getData2;

    public synchronized void doLongTimeTask() {
        try {
            System.out.println("开始任务");
            Thread.sleep(3000);
            getData1 = "长时间处理任务后从远程返回的值1 线程名称=" + Thread.currentThread().getName();
            getData2 = "长时间处理任务后从远程返回的值2 线程名称=" + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("结束任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
