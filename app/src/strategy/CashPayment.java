package strategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public double calculateTotal(double amount) {
        return amount;
    }

    @Override
    public String getName() {
        return "Cash";
    }
}