import java.util.*;

// Observer Pattern
interface Observer {
    void update(String message);
}

// Subject
class SmartHomeHub {
    private List<Observer> observers = new ArrayList<>();
    private Map<Integer, SmartDevice> devices = new HashMap<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addDevice(SmartDevice device) {
        devices.put(device.getId(), device);
    }

    public void turnOn(int id) {
        SmartDevice device = devices.get(id);
        if (device != null) {
            device.turnOn();
            notifyObservers(device.getStatus());
        }
    }

    public void turnOff(int id) {
        SmartDevice device = devices.get(id);
        if (device != null) {
            device.turnOff();
            notifyObservers(device.getStatus());
        }
    }

    public void setSchedule(int id, String time, String command) {
        // Schedule implementation
    }

    public void addTrigger(String condition, String action) {
        // Trigger implementation
    }

    public void showStatus() {
        for (SmartDevice device : devices.values()) {
            System.out.println(device.getStatus());
        }
    }
}

// Device Factory Method
abstract class SmartDevice {
    protected int id;
    protected String type;
    protected String status;

    public SmartDevice(int id, String type) {
        this.id = id;
        this.type = type;
        this.status = "off";
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public String getStatus() {
        return type.substring(0, 1).toUpperCase() + type.substring(1) + " " + id + " is " + status + ".";
    }
}

class Light extends SmartDevice {
    public Light(int id) {
        super(id, "light");
    }

    @Override
    public void turnOn() {
        status = "on";
    }

    @Override
    public void turnOff() {
        status = "off";
    }
}

class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(int id, int temperature) {
        super(id, "thermostat");
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        status = "on";
    }

    @Override
    public void turnOff() {
        status = "off";
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        status = "on"; // Just an example
    }
}

class DoorLock extends SmartDevice {
    public DoorLock(int id) {
        super(id, "door lock");
    }

    @Override
    public void turnOn() {
        status = "locked";
    }

    @Override
    public void turnOff() {
        status = "unlocked";
    }
}

// Device Factory
class DeviceFactory {
    public static SmartDevice createDevice(int id, String type) {
        switch (type) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, 70); // Default temperature
            case "door lock":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Unknown device type");
        }
    }
}

// Main Class
public class SmartHomeSystem {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();

        SmartDevice light = DeviceFactory.createDevice(1, "light");
        SmartDevice thermostat = DeviceFactory.createDevice(2, "thermostat");
        SmartDevice door = DeviceFactory.createDevice(3, "door lock");

        hub.addDevice(light);
        hub.addDevice(thermostat);
        hub.addDevice(door);

        hub.turnOn(1); // Turn on light
        hub.turnOn(2); // Turn on thermostat
        hub.turnOff(3); // Unlock door

        hub.showStatus(); // Show status of all devices
    }
}
