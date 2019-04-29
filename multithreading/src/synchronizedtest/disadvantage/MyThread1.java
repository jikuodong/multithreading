package synchronizedtest.disadvantage;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName MyThread1.java
 * @createTime 2019年04月29日 15:48:00
 */
public class MyThread1 extends Thread{
    private Task task;
    public MyThread1(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
