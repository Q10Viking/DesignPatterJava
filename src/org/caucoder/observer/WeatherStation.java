package org.caucoder.observer;

/**
 * 模拟气象站物理基站检测到数据，到不同布告板上显示
 */
public class WeatherStation {
    public static void main(String[] args) {
        // 主题
        WeatherData weatherData = new WeatherData();
        // 三个布告板订阅者,需要注册到主题中
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecaseDisplay forecaseDisplay = new ForecaseDisplay(weatherData);

        // 模拟物理气象基站数据更新-> 导致主题数据状态更新
        System.out.println("主题第一次更新");
        weatherData.setMeasurementsData(80,65,30);
        System.out.println("主题第二次更新");
        weatherData.setMeasurementsData(82,70,20);
        System.out.println("主题第三次更新");
        weatherData.setMeasurementsData(78,90,29);
    }
}
/**
 主题第一次更新
 ---------------当前气象数据------------------
 Current conditions: 80F degrees and 65% humidity
 ---------------气象统计数据------------------
 Avg/Max/Min temperature = 80/80/80
 ---------------当前天气预报------------------
 Improving weather on the way!
 主题第二次更新
 ---------------当前气象数据------------------
 Current conditions: 82F degrees and 70% humidity
 ---------------气象统计数据------------------
 Avg/Max/Min temperature = 81/82/80
 ---------------当前天气预报------------------
 Watch out for cooler, rainy weather
 主题第三次更新
 ---------------当前气象数据------------------
 Current conditions: 78F degrees and 90% humidity
 ---------------气象统计数据------------------
 Avg/Max/Min temperature = 80/82/78
 ---------------当前天气预报------------------
 Improving weather on the way!
 */