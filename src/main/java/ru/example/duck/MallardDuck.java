package ru.example.duck;

import ru.example.behavior.fly.FlyWithWings;
import ru.example.behavior.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("Real duck");
    }

}
