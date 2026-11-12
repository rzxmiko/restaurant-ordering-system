package strategy;

public class PromoCodePayment implements PaymentStrategy {
    private final String code;
    private final double discount;

    public PromoCodePayment(String code, double discount) {
        this.code = code;
        this.discount = discount; // e.g. 0.15
    }

    @Override
    public double calculateTotal(double amount) {
        return amount * (1 - discount);
    }

    @Override
    public String getName() {
        return "Promo code " + code + " (" + (int) (discount * 100) + "% discount)";
    }
}