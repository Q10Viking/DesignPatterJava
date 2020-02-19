package org.caucoder.strategy;

/**
 * 鸭子抽象类
 */
public abstract class Duck {
    /** 面向行为，呱呱接口 */
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public Duck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    /** 只关心动作的正确性，而不关心其具体细节 */
    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }
    /** 通过继承，子类全部共享的方法 */
    public void swim(){
        System.out.println("All ducks float,even decoys.");
    }

    /** 允许子类动态更改行为 */
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    /** 子类各自的表现形式 */
    public abstract void display();
}
