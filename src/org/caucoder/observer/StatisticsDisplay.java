package org.caucoder.observer;

/**
 * 气象统计数据布告板展示
 */
public class StatisticsDisplay implements Observer, DisplayElement {
    private int maxTemp = 0;
    private int minTemp = 200;
    private int tempSum= 0;
    private int numReadings;
    private Subject weatherData;

    public StatisticsDisplay(Subject subject){
        this.weatherData = subject;
        this.weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("---------------气象统计数据------------------");
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        this.tempSum += temperature;
        numReadings++;

        if (temperature > maxTemp) {
            maxTemp = temperature;
        }

        if (temperature < minTemp) {
            minTemp = temperature;
        }

        display();
    }
}
