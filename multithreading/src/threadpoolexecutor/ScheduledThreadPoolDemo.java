package threadpoolexecutor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * describe 使用ScheduledExecutorService和ScheduledThreadPoolExecutor实现的java调度程序示例程序。
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ScheduledThreadPoolDemo.java
 * @createTime 2019年05月09日 16:40:00
 */
public class ScheduledThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个ScheduledThreadPoolExecutor对象
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        // 计划在某段时间段后运行
        System.out.println("当前时间= "+new Date());
        /*for (int i = 0; i < 3; i++) {
            WorkerThread workerThread = new WorkerThread("do heavy processing");
            // 创建并执行在给定延迟后启用的单次操作。
            // scheduledExecutorService.schedule(workerThread,10, TimeUnit.SECONDS);

            // 安排任务在初始延迟后运行，然后在给定的时间段内运行。
            scheduledExecutorService.scheduleAtFixedRate(workerThread,0,10,TimeUnit.SECONDS);
        }*/
        for (int i = 0; i < 3; i++) {
            WorkerThread worker = new WorkerThread("do heavy processing");
            scheduledExecutorService.scheduleWithFixedDelay(worker, 0, 1,
                    TimeUnit.SECONDS);
        }


        // 添加一些延迟让调度程序产生一些线程
        Thread.sleep(30000);
        System.out.println("当前时间1 = " + new Date());
        // 关闭线程池
        scheduledExecutorService.shutdown();
        while (! scheduledExecutorService.isTerminated()) {
            // 等待所有任务完成
        }
        System.out.println("所有线程完成");
    }
}
