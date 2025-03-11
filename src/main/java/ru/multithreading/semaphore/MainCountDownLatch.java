package ru.multithreading.semaphore;

import java.util.concurrent.CountDownLatch;

public class MainCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        new Thread(new SomeClass(cdl)).start();

        try {
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End of the program");
    }
}

class SomeClass implements Runnable {

    private final CountDownLatch countDownLatch;

    public SomeClass(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            countDownLatch.countDown();
        }
    }
}
