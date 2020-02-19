package org.caucoder.observer;

/**
 * 天气预报布告板
 */
public class ForecaseDisplay implements Observer,DisplayElement {
    private int currentPressure = 27;
    private int lastPressure;
    private Subject weatherData;

    public ForecaseDisplay(Subject subject){
        this.weatherData = subject;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("---------------当前天气预报------------------");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }
}
