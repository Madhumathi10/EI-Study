// Notification interface
interface Notification {
    String send(String message);
}

// Concrete notification
class BasicNotification implements Notification {
    @Override
    public String send(String message) {
        return "Sending notification: " + message;
    }
}

// Decorator class
abstract class NotificationDecorator implements Notification {
    protected Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public String send(String message) {
        return notification.send(message);
    }
}

// Concrete decorators
class EmailDecorator extends NotificationDecorator {
    public EmailDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String send(String message) {
        return super.send(message) + " via Email";
    }
}

class SMSDecorator extends NotificationDecorator {
    public SMSDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String send(String message) {
        return super.send(message) + " via SMS";
    }
}

// Usage
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Notification notification = new BasicNotification();
        Notification emailNotification = new EmailDecorator(notification);
        Notification smsNotification = new SMSDecorator(emailNotification);

        System.out.println(smsNotification.send("Hello World"));
    }
}