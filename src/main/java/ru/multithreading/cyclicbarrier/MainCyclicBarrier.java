package ru.multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new MyAction());
        new Thread(new MyThread(cyclicBarrier, "1")).start();
        Thread.sleep(100);
        new Thread(new MyThread(cyclicBarrier, "2")).start();
        Thread.sleep(100);
        new Thread(new MyThread(cyclicBarrier, "3")).start();
        Thread.sleep(100);
        new Thread(new MyThread(cyclicBarrier, "4")).start();
        Thread.sleep(100);
        new Thread(new MyThread(cyclicBarrier, "5")).start();
        Thread.sleep(100);
        new Thread(new MyThread(cyclicBarrier, "6")).start();
    }
}

class MyThread implements Runnable {

    private final CyclicBarrier cyclicBarrier;
    private final String threadName;

    public MyThread(CyclicBarrier cyclicBarrier, String threadName) {
        this.cyclicBarrier = cyclicBarrier;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Tread: " + threadName);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyAction implements Runnable {

    @Override
    public void run() {
        System.out.println("Barrier is reached!!!");
    }
}
