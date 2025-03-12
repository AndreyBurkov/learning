package ru.test;

import java.net.URISyntaxException;
import java.util.function.Function;

public class MainTest {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        Integer x = 10;
        Function<Integer, String> function = integer -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return String.valueOf(integer + x);
        };

        System.out.println(x);
        System.out.println(function.apply(x));

    }

}







