package ru.test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class MainTest {

    public static void main(String args[]) throws InterruptedException {
        new HashMap<>()
        new B().get();
    }

    private static class A {

        public void get() {
            System.out.println("A");
        }
    }

    private static class B extends A {


        private void get() {
            super.get();
            System.out.println("B");
            super.get();
        }

    }


}





