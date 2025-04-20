package ru.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainTest {

    public static void main(String args[]) throws InterruptedException {
        int[] nums = {1, 2, 3, 4, 5};
        String[] strs = {"asdf","zxcv"};
        Stream<String> stream = Arrays.stream(strs);

        Stream.builder().add("asdf").add(new ArrayList<>()).build().forEach(System.out::println);

    }


}





