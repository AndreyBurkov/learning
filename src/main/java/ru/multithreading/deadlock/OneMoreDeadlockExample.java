package ru.multithreading.deadlock;

public class OneMoreDeadlockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток 1 захватил lock1");
                try {
                    Thread.sleep(50); // задержка для увеличения вероятности deadlock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Поток 1 захватил lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Поток 2 захватил lock2");
                try {
                    Thread.sleep(50); // задержка для увеличения вероятности deadlock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Поток 2 захватил lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
