package ru.test;

public class MainTest {

    private int xx;

    public static void main(String args[]) throws InterruptedException {
        try {
            if (1>0) throw new Exception("asdf");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("asfd");
        }
    }

    class A {
        private int x, y;

        public A() {
            this.x = x;
        }
    }

    class B extends A {


    }


}





