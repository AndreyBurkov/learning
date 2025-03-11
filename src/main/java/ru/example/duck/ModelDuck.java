package ru.example.duck;

import ru.example.behavior.fly.FlyNoWay;
import ru.example.behavior.fly.FlyWithWings;
import ru.example.behavior.quack.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("Model duck");
    }

}
