package ru.multithreading.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutorService {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch1 = new CountDownLatch(5);
        CountDownLatch countDownLatch2 = new CountDownLatch(5);
        CountDownLatch countDownLatch3 = new CountDownLatch(5);
        CountDownLatch countDownLatch4 = new CountDownLatch(5);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        System.out.println("Starting threads");

        executor.execute(new MyThread("A", countDownLatch1));
        executor.execute(new MyThread("B", countDownLatch2));
        executor.execute(new MyThread("C", countDownLatch3));
        executor.execute(new MyThread("D", countDownLatch4));

        countDownLatch1.await();
        countDownLatch2.await();
        countDownLatch3.await();
        countDownLatch4.await();

        executor.shutdown();
        System.out.println("END of main thread");
    }
}

class MyThread implements Runnable {

    private final String threadName;
    private final CountDownLatch countDownLatch;

    public MyThread(String threadName, CountDownLatch countDownLatch) {
        this.threadName = threadName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + ": " + i);
            countDownLatch.countDown();
        }
    }
}
