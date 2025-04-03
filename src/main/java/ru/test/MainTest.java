package ru.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainTest {

    public static void main(String[] args) {

        List<String> socks = List.of("red", "green", "blue", "pink", "blue", "red", "blue", "pink", "yellow");

        List<String> result = socks.stream().collect(Collectors.groupingBy(String::toString)).entrySet().stream()
                .filter(entry -> entry.getValue().size() % 2 != 0).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(result);

        long count = socks.stream().collect(Collectors.groupingBy(String::toString)).entrySet().stream()
                .filter(entry -> entry.getValue().size() % 2 != 0).count();

        System.out.println(count);
///////////////////////////////////////////////

        final int SIZE = 100_000;

        ArrayList<Integer> integers = new ArrayList<>(SIZE);
        for (int i = 1; i <= SIZE; i++) {
            integers.add(i);
        }

        long startTime = System.nanoTime();
        long sum = integers.stream().mapToLong(value -> value).sum();
        double elapsedTime = (System.nanoTime() - startTime) / 1_000_000_000d;
        System.out.println("sum=" + sum + " ; elapsedTime=" + elapsedTime);


        startTime = System.nanoTime();
        sum = integers.stream().mapToLong(value -> value).parallel().sum();
        elapsedTime = (System.nanoTime() - startTime) / 1_000_000_000d;
        System.out.println("sum=" + sum + " ; elapsedTime=" + elapsedTime);


//         sum = integers.stream().mapToInt(value -> value).parallel().sum();


    }

}