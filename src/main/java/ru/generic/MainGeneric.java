package ru.generic;

public class MainGeneric {

    public static void main(String[] args) {
        Gen<Integer> iob1 = new Gen<>(1);
        Gen<Integer> iob2 = new Gen2<>(2);
        Gen<String> str2 = new Gen2<>("asDF");

        System.out.println(iob1 instanceof Gen);

    }

}

class Gen<T> {
    T ob;

    Gen(T о) {
        ob = о;
    }

    T getOb() {
        return ob;
    }
}

class Gen2<T> extends Gen<T> {
    Gen2(T o) {
        super(o);
    }
}
