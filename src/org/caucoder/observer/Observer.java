package org.caucoder.observer;

/**
 * 观察者接口
 */
public interface Observer {
    /**
     * 主题统一调用观察者接口
     * @param temperature 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    public void update(int temperature,int humidity,int pressure);
}
