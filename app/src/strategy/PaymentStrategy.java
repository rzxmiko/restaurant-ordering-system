package strategy;

public interface PaymentStrategy {
    double calculateTotal(double amount);

    String getName();
}