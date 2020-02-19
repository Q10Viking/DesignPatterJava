package org.caucoder.strategy;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        /** 具体的行为实现 */
        System.out.println("I'm flying.");
    }
}
