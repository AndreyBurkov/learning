package ru.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class MainSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Thread(new Incrementer("Thread_A", semaphore)).start();
        new Thread(new Decrementer("Thread_B", semaphore)).start();
    }
}

class SharedResource {
    static Integer value = 0;
}

class Incrementer implements Runnable {

    private final String threadName;
    private final Semaphore semaphore;

    public Incrementer(String threadName, Semaphore semaphore) {
        this.threadName = threadName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadName + " started.");
        try {
            System.out.println(threadName + ": trying to get access to shared resource");
            semaphore.acquire();
            System.out.println(threadName + ": got access to shared resource");
            for (int i = 0; i < 5; i++) {
                SharedResource.value++;
                System.out.println(threadName + ": " + SharedResource.value);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName + ": release access to shared resource");
        semaphore.release();
        System.out.println(threadName + ": END");
    }
}

class Decrementer implements Runnable {

    private final String threadName;
    private final Semaphore semaphore;

    public Decrementer(String threadName, Semaphore semaphore) {
        this.threadName = threadName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadName + " started.");
        try {
            System.out.println(threadName + ": trying to get access to shared resource");
            semaphore.acquire();
            System.out.println(threadName + ": got access to shared resource");
            for (int i = 0; i < 5; i++) {
                SharedResource.value--;
                System.out.println(threadName + ": " + SharedResource.value);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName + ": release access to shared resource");
        semaphore.release();
        System.out.println(threadName + ": END");
    }
}
