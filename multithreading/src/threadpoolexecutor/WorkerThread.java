package threadpoolexecutor;

import java.util.Date;

/**
 * describe 这是一个简单的Runnable类，需要大约5秒钟来执行其任务。
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName WorkerThread.java
 * @createTime 2019年05月09日 11:39:00
 */
public class WorkerThread  implements  Runnable{

    private String command;
    public WorkerThread(String s) {
        this.command = s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 开始时间=" + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" 结束时间=" + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
            System.out.println("================正在输出代码===========");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
