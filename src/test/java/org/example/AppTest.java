package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AppTest {

    @Test
    public void optionalTest() {

        Optional<String> optional1 = Optional.empty();
        assertFalse(optional1.isPresent());

        String str = "Some string";
        Optional<String> optional2 = Optional.of(str);
        assertTrue(optional2.isPresent());

        String nullString = null;
        Optional<String> optional3 = Optional.ofNullable(nullString);
        assertTrue(optional3.isEmpty());

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
