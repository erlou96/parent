package sdk.thread;

import java.util.concurrent.CountDownLatch;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("<=================A项目方法开始==============>");
        CountDownLatch latch = new CountDownLatch(3);
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B项目接口调用===开始");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B项目接口调用===结束");
                latch.countDown();
            }
        });

        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("C项目接口调用===开始");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C项目接口调用===结束");
                latch.countDown();
            }
        });

        Thread D = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D项目接口调用===开始");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("D项目接口调用===结束");
                latch.countDown();
            }
        });
        System.out.println("B C D start");
        B.start();
        C.start();
        D.start();
        latch.await();
        System.out.println("<=================A项目方法结束==============>");
    }
}

