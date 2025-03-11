package ru.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class MainSemaphoreQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

class MyQueue {

    private final Semaphore producerSemaphore = new Semaphore(1);
    private final Semaphore consumerSemaphore = new Semaphore(0);
    private int value;

    void put(int value) {
        try {
            producerSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.value = value;
        System.out.println("put: " + value);
        consumerSemaphore.release();
    }

    void get() {
        try {
            consumerSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("get: " + value);
        producerSemaphore.release();
    }

}

class Producer implements Runnable {

    private final MyQueue queue;

    public Producer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            queue.put(i);
        }
    }
}

class Consumer implements Runnable {

    private final MyQueue queue;

    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            queue.get();
        }
    }
}