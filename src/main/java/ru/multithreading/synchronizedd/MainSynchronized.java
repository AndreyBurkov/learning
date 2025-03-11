package ru.multithreading.synchronizedd;

public class MainSynchronized {

    public static void main(String[] args) {
        String userName = "Alex";
        User user = new User(userName);

        new Thread(new MyThread(user, "A"), "A").start();
        new Thread(new MyThread(user, "B"), "B").start();
        new Thread(new MyThread(user, "C"), "C").start();

        System.out.println("End of main thread");
    }

}

class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printUsername() {
        synchronized (this) { // тут блокируется текущий объект
            System.out.print(Thread.currentThread().getName() + ": username from synchronized block = ");
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        }
    }

    public synchronized void printUsernameSynchMethod() { // тут тоже блокируется текущий объект
        System.out.print(Thread.currentThread().getName() + ": username from synchronized method = ");
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    public static synchronized void printUsernameStatic(String name) { // тут блокируется User.class
        System.out.print(Thread.currentThread().getName() + ": username from synchronized STATIC method = ");
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

}


class MyThread implements Runnable {

    private final User user;
    private final String threadName;

    public MyThread(User user, String threadName) {
        this.user = user;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Started thread: " + threadName);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        user.printUsername();
        user.printUsernameSynchMethod();
        User.printUsernameStatic(user.getName());
    }
}
