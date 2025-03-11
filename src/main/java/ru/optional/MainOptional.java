package ru.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Please, check TEST class
public class MainOptional {

    public static void main(String[] args) {
        Optional<String> optional1 = Optional.empty();
        System.out.println(optional1.isPresent()); // false

        String str = "Some string";
        Optional<String> optional2 = Optional.of(str);
        System.out.println(optional2.isPresent()); // true

        String nullString = null;
        Optional<String> optional3 = Optional.ofNullable(nullString);
        System.out.println(optional3.isEmpty()); // true

        Optional<String> optional4 = Optional.ofNullable("Hello");
        optional4.ifPresent(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println(optional3.orElse("wow"));

        Optional<String> optional5 = Optional.ofNullable(nullString);
        String name = optional5.orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                return "other name";
            }
        });
        System.out.println(name);
    }
}
