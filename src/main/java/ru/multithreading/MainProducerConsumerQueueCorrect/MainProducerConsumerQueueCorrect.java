package ru.multithreading.MainProducerConsumerQueueCorrect;

public class MainProducerConsumerQueueCorrect {

    public static void main(String[] args) {
        Q q = new Q();

        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

    }

}

class Q {

    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Получено: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Отправлено: " + n);
        notify();
    }
}

class Producer implements Runnable {

    Q queue;

    Producer(Q q) {
        queue = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
//        while (true) {
//            queue.put(i++);
//        }
        for (int j = 0; j < 100; j++) {
            queue.put(i++);
        }
    }
}

class Consumer implements Runnable {

    Q queue;

    Consumer(Q q) {
        queue = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
//        while (true) {
//            queue.get();
//        }
        for (int j = 0; j < 100; j++) {
            queue.get();
        }
    }
}
