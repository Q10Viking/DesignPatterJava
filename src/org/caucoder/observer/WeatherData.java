package org.caucoder.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    /**
     * 组合观察者
     */
    private List<Observer> observers = null;

    /**
     * 气象站数据
     */
    private int temperature; // 温度
    private int humidity;   // 湿度
    private int pressure;   // 气压


    public WeatherData(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if(index>= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObserver() {
        for(Observer observer: observers){
            observer.update(temperature,humidity,pressure);
        }
    }

    /**
     * 气象站数据更新，通知公布版
     */
    public void measurementsChange(){
        notifyObserver();
    }

    /**
     * 模拟物理基站给这个对象赋数据
     */
    public void setMeasurementsData(int temperature,int humidity,int pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChange();
    }

}
