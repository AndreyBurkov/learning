package ru.multithreading;

import java.util.Stack;
import java.util.logging.Logger;

public class MainMultithreading {

    private static final Logger logger = Logger.getGlobal();

    private static void main(String name, int age) {

    }

    public static void main(String[] args) {

        String str1 = "HelloWorld";
        String temp = "World";
        String str2 = "Hello" + "World";
        String str3 = "Hello" + temp;
        String str4 = new String("HelloWorld");

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 == str3: " + (str1 == str3));
        System.out.println("str1 == str4:" + (str1 == str4));

        Stack<Character> stack = new Stack<>();
        stack.push('a');


    }
}


class A {
    private int a;
    private int b;

    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class B extends A {

    private int c;

    public B() {
        super(0, 0);
        c = 0;
    }

    public B(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }
}