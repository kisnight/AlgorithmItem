package study.demo.threadpool.newsinglethreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*
    练习Executors获取ExecutorService,然后调用方法,提交任务;
    单线程化线程池
    特点：只有 1 个核心线程，无非核心线程，执行完立即回收，任务队列为链表结构的有界队列。
    应用场景：不适合并发但可能引起 IO 阻塞性及影响 UI 线程响应的操作，如数据库操作、文件操作等。
 */
public class MyTest03 {
    public static void main(String[] args) {
        //test1();
        test2();
    }
    //练习方法newFixedThreadPool
    private static void test1() {
        //1:使用工厂类获取线程池对象
        ExecutorService es = Executors.newSingleThreadExecutor();
        //2:提交任务;
        for (int i = 1; i <=10 ; i++) {
            es.submit(new MyRunnable3(i));
        }
    }
    private static void test2() {
        //1:使用工厂类获取线程池对象
        ExecutorService es = Executors.newSingleThreadExecutor(new ThreadFactory() {
            int n=1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义的线程名称"+n++);
            }
        });
        //2:提交任务;
        for (int i = 1; i <=10 ; i++) {
            es.submit(new MyRunnable3(i));
        }
    }
}

/*
    任务类,包含一个任务编号,在任务中,打印出是哪一个线程正在执行任务
 */
class MyRunnable3 implements Runnable{
    private  int id;
    public MyRunnable3(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        //获取线程的名称,打印一句话
        String name = Thread.currentThread().getName();
        System.out.println(name+"执行了任务..."+id);
    }
}

