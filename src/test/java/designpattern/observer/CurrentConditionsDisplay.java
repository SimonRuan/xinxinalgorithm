package designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    Observable observable;

    //观察者要订阅的主题，是观察者本身的一个私有成员变量，在初始化观察者的时候要为这个主题赋值，
    //并且将自身注册到这个主题上，这样，主题维护的订阅者列表就新增了一个成员
    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("布告板 Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }


    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }


}
