// Singleton class
class SingletonLogger {
    private static SingletonLogger instance;

    private SingletonLogger() { }

    public static SingletonLogger getInstance() {
        if (instance == null) {
            instance = new SingletonLogger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}

// Usage
public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingletonLogger logger1 = SingletonLogger.getInstance();
        SingletonLogger logger2 = SingletonLogger.getInstance();

        logger1.log("Singleton pattern applied");

        System.out.println(logger1 == logger2); // Output: true
    }
}