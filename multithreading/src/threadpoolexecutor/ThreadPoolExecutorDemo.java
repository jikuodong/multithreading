package threadpoolexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ThreadPoolExecutorDemo.java
 * @createTime 2019年05月09日 11:45:00
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // 创建一个FixedThreadPool对象
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            // 创建WorkerThead对象（WorkerThread类实现了Runnable接口）
            Runnable worker = new WorkerThread(" " + i);
            // 执行Runnable
            executorService.execute(worker);
        }
        // 终止线程池
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println("完成所有的线程！");
    }
}
