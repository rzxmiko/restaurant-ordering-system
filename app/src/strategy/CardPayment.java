package strategy;

public class CardPayment implements PaymentStrategy {
    private static final double DISCOUNT = 0.05; // 5% cashback

    @Override
    public double calculateTotal(double amount) {
        return amount * (1 - DISCOUNT);
    }

    @Override
    public String getName() {
        return "Card (5% discount)";
    }
}