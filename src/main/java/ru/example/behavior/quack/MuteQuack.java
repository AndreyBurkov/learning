package ru.example.behavior.quack;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<< silence >>");
    }

}
