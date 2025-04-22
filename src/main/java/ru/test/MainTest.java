package ru.test;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainTest {

    public static void main(String args[]) throws InterruptedException {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add(null);
        


        Map<String ,BigInteger> map = new ConcurrentHashMap<>();
        map.put(null, null);
        map.put(null, BigInteger.TEN);

        System.out.println(map);

    }


}





