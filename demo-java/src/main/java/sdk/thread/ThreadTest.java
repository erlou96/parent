package sdk.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

    public static void main(String[] args) {
        // 1.继承Thread类
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        thread.start();
        // 1.1 lambda方式启动
        Thread thread11 = new Thread(() -> {
            System.out.println("lambda方式创建线程");
        });
        thread11.start();

        // 2.重写runnable接口
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable启动线程");
            }
        });
        thread1.start();

        // 3.通过callable启动，然后提交给线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<String> callable = new Callable() {
            @Override
            public String call() throws Exception {
                String str = new String("Callable启动线程");
                return str;
            }
        };
        Future<String> submit = executorService.submit(callable);
        try {
            String s = submit.get();
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            executorService.shutdown();
        }
    }
}
