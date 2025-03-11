package ru.example.ducksimulator;

import ru.example.behavior.fly.FlyRocketPowered;
import ru.example.duck.Duck;
import ru.example.duck.MallardDuck;
import ru.example.duck.ModelDuck;

public class Main {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();

        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();
    }

}
