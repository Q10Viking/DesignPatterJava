package org.caucoder.Jobserver;

import java.util.Observable;

public class WeatherData extends Observable {
    /**
     * 气象站数据
     */
    private int temperature; // 温度
    private int humidity;   // 湿度
    private int pressure;   // 气压

    /**
     * 气象站数据更新，通知公布版
     */
    public void measurementsChange(){
        // 在调用notifyObservers之前需要调用该方法，表示状态已经该改变
        setChanged(); // set change = true
        //notifyObservers();  // 订阅者拉数据
        notifyObservers(this);  //主题推数据
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

    /**
     * 添加getter方法方便订阅者获取数据pull
     */
    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }
}
