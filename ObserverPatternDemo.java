
import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float temperature, float humidity);
}

// WeatherStation class
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setWeather(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }
    }
}

// Concrete observers
class TemperatureDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Temperature Display: " + temperature + "°C");
    }
}

class HumidityDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Humidity Display: " + humidity + "%");
    }
}

// Usage
public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        TemperatureDisplay tempDisplay = new TemperatureDisplay();
        HumidityDisplay humidityDisplay = new HumidityDisplay();

        weatherStation.addObserver(tempDisplay);
        weatherStation.addObserver(humidityDisplay);

        weatherStation.setWeather(25, 60);
    }
}


