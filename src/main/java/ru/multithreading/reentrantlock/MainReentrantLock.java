package ru.multithreading.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class MainReentrantLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(new LockThread("A", lock)).start();
        new Thread(new LockThread("B", lock)).start();
    }

}

class Shared {
    public static int count = 1;
}

class LockThread implements Runnable {

    private final String name;
    private final ReentrantLock lock;

    public LockThread(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("Start of tread: " + name);
        try {
            System.out.println("Thread " + name + " is waiting for lock");
            lock.lock();
            System.out.println("Thread " + name + " locks the counter");
            Shared.count++;
            System.out.println("Thread " + name + ": " + Shared.count);
            System.out.println("Thread " + name + " is sleeping...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Thread " + name + " unblocks the counter");
            lock.unlock();
        }
    }
}