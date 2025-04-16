package ru.multithreading.deadlock;

public class MainDeadLockExample implements Runnable {

    final A a = new A();
    final B b = new B();

    public MainDeadLockExample() {
        Thread.currentThread().setName("Main thread");
        Thread t = new Thread(this, "Second thread");
        t.start();

        a.runA(b);
    }

    @Override
    public void run() {
        b.runB(a);
    }

    public static void main(String[] args) {
        new MainDeadLockExample();
    }



    class A {

        public synchronized void runA(B b) {
            System.out.println("A is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b.getB();
        }

        public synchronized void getA() {
            System.out.println("getA is triggered");
        }

    }

    class B {

        public synchronized void runB(A a) {
            System.out.println("B is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            a.getA();
        }

        public synchronized void getB() {
            System.out.println("getB is triggered");
        }

    }

}
