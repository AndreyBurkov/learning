package ru.multithreading.synchronizedd;

public class MainSynch {

    public static void main(String[] args) {
        CallMe target = new CallMe();

        Caller caller1 = new Caller(target, "Welcome");
        Caller caller2 = new Caller(target, "to synchronized");
        Caller caller3 = new Caller(target, "world!");

        try {
            caller1.t.join();
            caller2.t.join();
            caller3.t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

class CallMe {

    //    public synchronized void call(String message) {
    public void call(String message) {
        System.out.print("[" + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("]");
    }

}

class Caller implements Runnable {

    final String msg;
    final CallMe target;
    final Thread t;

    public Caller(CallMe target, String msg) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }

}
