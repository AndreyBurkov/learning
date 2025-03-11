package ru.multithreading.MainProducerConsumerQueueWrong;

public class MainProducerConsumerQueueWrong {

    public static void main(String[] args) {
        Q q = new Q();

        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

    }

}

class Q {
    int n;

    synchronized int get() {
        System.out.println("Получено: " + n);
        return n;
    }

    synchronized void put(int n) {
        this.n = n;
        System.out.println("Отправлено: " + n);
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
