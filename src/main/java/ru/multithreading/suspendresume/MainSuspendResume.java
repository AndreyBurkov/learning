package ru.multithreading.suspendresume;

public class MainSuspendResume {

    public static void main(String[] args) {
        NewThread t1 = new NewThread("First thread");
        NewThread t2 = new NewThread("Second thread");

        try {
            Thread.sleep(1000);
            t1.suspend();
            System.out.println("Thread '" + t1.threadName + "' is suspended");
            Thread.sleep(1000);
            t1.resume();
            System.out.println("Thread '" + t1.threadName + "' is resumed");

            t2.suspend();
            System.out.println("Thread '" + t2.threadName + "' is suspended");
            Thread.sleep(1000);
            t2.resume();
            System.out.println("Thread '" + t2.threadName + "' is resumed");

            t1.t.join();
            t2.t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

class NewThread implements Runnable {

    final String threadName;
    final Thread t;
    private boolean suspendFlag;

    public NewThread(String threadName) {
        this.threadName = threadName;
        t = new Thread(this, threadName);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName + " is completed");
    }

    public synchronized void suspend() {
        suspendFlag = true;
    }

    public synchronized void resume() {
        suspendFlag = false;
        notify();
    }

}
