package ru.multithreading.exchanger;

import java.util.concurrent.Exchanger;

public class MainExchanger {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new StringUser(exchanger)).start();
        new Thread(new StringMaker(exchanger)).start();
    }
}

class StringMaker implements Runnable {

    private final Exchanger<String> exchanger;
    private String str;

    public StringMaker(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        str = new String();
    }

    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 5; j++) {
                str += (char) ch++;
            }

            try {
                str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class StringUser implements Runnable {

    private final Exchanger<String> exchanger;
    private String str;

    public StringUser(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = exchanger.exchange(new String());
                System.out.println("Got: " + str);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
