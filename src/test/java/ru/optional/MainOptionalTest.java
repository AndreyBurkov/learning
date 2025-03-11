package ru.optional;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainOptionalTest {

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

    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;

        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("some default", defaultText);

        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("some default", defaultText);
    }

    @Test
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String text = "cannot be null!";

        System.out.print("Метод orElseGet:");
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("cannot be null!", defaultText);

        System.out.print("\nМетод orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("cannot be null!", defaultText);
    }

    public String getMyDefault() {
        System.out.println("Inside getMyDefault()");
        return "some default";
    }

    @Test
    public void whenOrElseThrowWorks_thenCorrect() {
        final String nullName = null;
        assertThrows(IllegalArgumentException.class,
                () -> Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new));
    }

    @Test
    public void whenNoArgOrElseThrowWorks_thenCorrect() {
        final String nullName = null;
        assertThrows(NoSuchElementException.class,
                () -> Optional.ofNullable(nullName).orElseThrow());
    }

    @Test
    public void whenOptionalFilterWorks_thenCorrect() {
        Integer year = 2022;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2022 = yearOptional.filter(y -> y == 2022).isPresent();
        assertTrue(is2022);
        boolean is2021 = yearOptional.filter(y -> y == 2021).isPresent();
        assertFalse(is2021);
    }

    @Test
    public void whenFiltersWithoutOptional_thenCorrect() {
        class Headphones {
            private Double price;

            public Headphones(Double price) {
                this.price = price;
            }

            public Double getPrice() {
                return price;
            }

            public void setPrice(Double price) {
                this.price = price;
            }

            public static boolean priceIsInRange(Headphones headphones) {
                return Optional.ofNullable(headphones)
                        .map(Headphones::getPrice)
                        .filter(p -> p >= 10)
                        .filter(p -> p <= 15)
                        .isPresent();
            }
        }

        assertTrue(Headphones.priceIsInRange(new Headphones(10.0)));
        assertFalse(Headphones.priceIsInRange(new Headphones(9.9)));
        assertFalse(Headphones.priceIsInRange(new Headphones(null)));
        assertFalse(Headphones.priceIsInRange(new Headphones(15.5)));
        assertFalse(Headphones.priceIsInRange(null));
    }

    @Test
    void test() {
        Optional<String> optional1 = Optional.ofNullable(null);
        Optional<String> optional2 = optional1.or(new Supplier<Optional<? extends String>>() {
            @Override
            public Optional<? extends String> get() {
                return Optional.of("or value");
            }
        });
        assertEquals("or value", optional2.get());

        optional1.ifPresentOrElse(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("consumer");
            }
        }, new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        });

        optional2.ifPresentOrElse(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("consumer");
            }
        }, new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        });

        Set<String> set = optional1.stream().collect(Collectors.toSet());
        System.out.println(set.size());
        set = optional2.stream().collect(Collectors.toSet());
        System.out.println(set.size());
    }

}