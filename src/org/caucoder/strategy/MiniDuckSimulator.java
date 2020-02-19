package org.caucoder.strategy;

/**
 * 场景模拟类
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();
        /** 动态改变行为 */
       duck.setFlyBehavior(new FlyWithWings());
       duck.setQuackBehavior(new MuteQuack());
       duck.performFly();
       duck.performQuack();
    }
}
/**
 I can't fly
 Quack... ...
 I'm flying.
 << silence >>
 */