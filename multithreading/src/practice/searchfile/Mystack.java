package practice.searchfile;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * describe 同步查找文件内容 ，如果文件特别多，就会创建很多的线程。 改写这个练习，使用线程池的方式来完成。
 *
 * 初始化一个大小是10的线程池
 *
 * 遍历所有文件，当遍历到文件是.java的时候，创建一个查找文件的任务，把这个任务扔进线程池去执行，继续遍历下一个文件
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Mystack.java
 * @createTime 2019年05月10日 15:28:00
 */
public class Mystack {
    public  static void search(File folder, final String search, ThreadPoolExecutor threadPool) {
        File[] fs = folder.listFiles();
        for (final File f : fs) {
            if(f.isDirectory()) {
                search(f,search,threadPool);
            }else {
                if (f.getAbsolutePath().contains(".java")){
                    threadPool.execute(new Runnable() {
                        @Override
                        public void run() {
                                try(FileReader fis = new FileReader(f);BufferedReader br = new BufferedReader(fis)) {
                                    while (true) {
                                        String line = br.readLine();
                                        if (line ==null){
                                            break;
                                        }
                                        if (line.contains(search)){
                                            System.out.println(Thread.currentThread().getName()+"找到子目标字符串"+search+",在文件："+f.getAbsolutePath());
                                            break;
                                        }
                                    }
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        String fpath="E:\\workspace\\case-manager-wuxi\\Case-Manager\\case-manage";
        File folder = new File(fpath);
        String searchContent="String";
        search(folder,searchContent,threadPool);
        long end=System.currentTimeMillis();
        System.out.println("花费的时间为："+(end-start)+"ms");
    }
}
