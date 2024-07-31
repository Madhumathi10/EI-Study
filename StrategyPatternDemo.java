// Strategy interface
interface RouteStrategy {
    String buildRoute(String start, String end);
}

// Concrete strategies
class DrivingStrategy implements RouteStrategy {
    @Override
    public String buildRoute(String start, String end) {
        return "Driving from " + start + " to " + end;
    }
}

class WalkingStrategy implements RouteStrategy {
    @Override
    public String buildRoute(String start, String end) {
        return "Walking from " + start + " to " + end;
    }
}

class BikingStrategy implements RouteStrategy {
    @Override
    public String buildRoute(String start, String end) {
        return "Biking from " + start + " to " + end;
    }
}

// Context class
class Navigator {
    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public String navigate(String start, String end) {
        return strategy.buildRoute(start, end);
    }
}

// Usage
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Navigator navigator = new Navigator(new DrivingStrategy());
        System.out.println(navigator.navigate("Point A", "Point B"));

        navigator.setStrategy(new WalkingStrategy());
        System.out.println(navigator.navigate("Point A", "Point B"));
    }
}