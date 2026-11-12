package strategy;

public class PaymentProcessor {
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public double pay(double amount) {
        double total = strategy.calculateTotal(amount);
        System.out.println("Payment: " + strategy.getName()
                + " | was " + amount + " KZT, total " + total + " KZT");
        return total;
    }
}