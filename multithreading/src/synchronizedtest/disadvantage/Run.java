package synchronizedtest.disadvantage;

/**
 * describe synchronized方法的缺点
 * 使用synchronized关键字声明方法有些时候是有很大的弊端的，
 * 比如我们有两个线程一个线程A调用同步方法后获得锁，那么另一个线程B就需要等待A执行完，
 * 但是如果说A执行的是一个很费时间的任务的话这样就会很耗时。
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Run.java
 * @createTime 2019年04月29日 15:56:00
 */
public class Run {
    public static void main(String[] args) {
        Task task = new Task();

        MyThread1 thread1 =new MyThread1(task);
        thread1.start();

        MyThread2 thread2 = new MyThread2(task);
        thread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }

        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }

        System.out.println("耗时："+ ((endTime - beginTime) / 1000));
    }
}
