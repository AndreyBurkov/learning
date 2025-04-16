package ru.test;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainTest {

    public static void main(String args[]) throws InterruptedException {
        String s1 = "hello";
        String s2 = "world";
        String s3 = s1 + s2;
        String s4 = "helloworld";
        String s5 = new String("helloworld");
        String s6 = s1.concat(s2);

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s4 == s6);
    }


}





