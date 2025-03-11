package ru.test;

import java.net.URISyntaxException;
import java.util.Optional;
import java.util.function.Supplier;

public class MainTest {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        Optional<String> optional = Optional.ofNullable("new");
        Optional<String> qwe = optional.or(() -> {
            System.out.println("qwe");
            return Optional.of("\"qwe\"");
        });

        System.out.println(qwe.orElse("vvv"));
    }

}







