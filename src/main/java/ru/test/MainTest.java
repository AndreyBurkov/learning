package ru.test;

import java.net.URISyntaxException;

public class MainTest {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        int i = 0;

        for (; i <= 10; calculate(i)) {
            System.out.println(i);
            i+=2;
        }

    }

    private static int calculate(int x) {
        return x++;
    }

}







