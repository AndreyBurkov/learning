package ru.test;

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

    }

}