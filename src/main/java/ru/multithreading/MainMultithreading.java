package ru.multithreading;

import java.util.concurrent.*;

public class MainMultithreading {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(3000);
            return "asdf";
        });

        String str = future.get();
        System.out.println(str);
        System.out.println("done");
    }
}
