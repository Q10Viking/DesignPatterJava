package org.caucoder.observer;

/**
 * 显示当前气象数值的布告板
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    private int temperature;
    private int humidity;
    /**
     * 主题引用，方便以后开发注销功能时调用
     */
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject subject){
        this.weatherData = subject;
        // 注册该观察者
        weatherData.registerObserver(this);
    }
    @Override
    public void update(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("---------------当前气象数据------------------");
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }
}
