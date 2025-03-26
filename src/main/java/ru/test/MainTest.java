package ru.test;

import java.net.URISyntaxException;

public class MainTest {

    private static Integer MAIN_CONST;

    static {
        System.out.println("Main static init");
        MAIN_CONST = 67676;
    }

    public static void main(String[] args) throws URISyntaxException, InterruptedException, ClassNotFoundException {
//        new B();
        new B("asdf");
//        System.out.println(MAIN_CONST);
    }

}

class A {

    private static Integer MAIN_CONST;

    static {
        System.out.println("A static init");
        MAIN_CONST = 67676;
    }

    private String value;

//    public A() {
//        System.out.println("Empty A constructor");
//    }

    public A(String value) {
        System.out.println("Value A constructor");
        this.value = value;
    }

}

class B extends A {

    private static Integer MAIN_CONST;

    static {
        System.out.println("B static init");
        MAIN_CONST = 67676;
    }

    private String value;

//    public B() {
//        System.out.println("Empty B constructor");
//    }

    public B(String value) {
//        super(value);
        System.out.println("Value B constructor");
        this.value = value;
    }

}





