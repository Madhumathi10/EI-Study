// Old payment system
class OldPaymentSystem {
    public String processPayment(float amount) {
        return "Processed " + amount + " via old system";
    }
}

// New payment API
class NewPaymentAPI {
    public String makePayment(float amount) {
        return "Payment of " + amount + " made using new API";
    }
}

// Adapter class
class PaymentAdapter {
    private NewPaymentAPI newPaymentAPI;

    public PaymentAdapter(NewPaymentAPI newPaymentAPI) {
        this.newPaymentAPI = newPaymentAPI;
    }

    public String processPayment(float amount) {
        return newPaymentAPI.makePayment(amount);
    }
}

// Usage
public class AdapterPatternDemo {
    public static void main(String[] args) {
        OldPaymentSystem oldSystem = new OldPaymentSystem();
        System.out.println(oldSystem.processPayment(100));

        NewPaymentAPI newApi = new NewPaymentAPI();
        PaymentAdapter adapter = new PaymentAdapter(newApi);
        System.out.println(adapter.processPayment(100));
    }
}
