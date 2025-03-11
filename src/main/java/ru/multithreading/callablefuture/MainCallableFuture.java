package ru.multithreading.callablefuture;

import java.util.concurrent.*;

public class MainCallableFuture {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        System.out.println("Start");
        Future<Integer> future1 = executor.submit(new Sum(10));
        Future<Double> future2 = executor.submit(new Hypot(3, 4));
        Future<Integer> future3 = executor.submit(new Factorial(5));

        try {
            System.out.println("Sum result=" + future1.get());
            System.out.println("Hypot result=" + future2.get());
            System.out.println("Factorial result=" + future3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
        System.out.println("End of the program");
    }
}

class Sum implements Callable<Integer> {

    private final int lastValue;

    public Sum(int lastValue) {
        this.lastValue = lastValue;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= lastValue; i++) {
            sum += i;
        }
        return sum;
    }
}

class Hypot implements Callable<Double> {

    private final double side1, side2;

    public Hypot(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public Double call() throws Exception {
        return Math.sqrt(side1 * side1 + side2 * side2);
    }
}

class Factorial implements Callable<Integer> {

    private final int n;

    public Factorial(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
