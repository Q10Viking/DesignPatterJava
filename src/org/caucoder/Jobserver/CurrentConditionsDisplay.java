package org.caucoder.Jobserver;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements DisplayElement, Observer {

    private int temperature;
    private int humidity;
    private Observable observable;
    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        System.out.println("---------------当前气象数据------------------");
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    /**
     *
     * @param o 主题
     * @param arg 传递的参数
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof  WeatherData){
            WeatherData weatherData = (WeatherData)o;
            temperature = weatherData.getTemperature();
            humidity = weatherData.getHumidity();
            display();
        }

    }
}
