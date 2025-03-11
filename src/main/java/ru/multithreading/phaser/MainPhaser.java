package ru.multithreading.phaser;

import java.util.concurrent.Phaser;

public class MainPhaser {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
//        Phaser phaser = new Phaser();
//        phaser.register();
        int currentPhase = 0;
        System.out.println("Starting threads");

        new Thread(new MyThread(phaser, "A")).start();
        new Thread(new MyThread(phaser, "B")).start();
        new Thread(new MyThread(phaser, "C")).start();

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " is done");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " is done");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " is done");

        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) {
            System.out.println("Phaser is terminated");
        }
    }
}

class MyThread implements Runnable {

    private final Phaser phaser;
    private final String threadName;

    public MyThread(Phaser phaser, String threadName) {
        this.phaser = phaser;
        this.threadName = threadName;
        this.phaser.register();
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + threadName + " is starting FIRST phase");
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(100);

            System.out.println("Thread " + threadName + " is starting SECOND phase");
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(100);

            System.out.println("Thread " + threadName + " is starting THIRD phase");
            phaser.arriveAndDeregister();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
