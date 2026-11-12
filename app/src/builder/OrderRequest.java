package builder;

import factory.Dish;
import strategy.PaymentStrategy;

public class OrderRequest {
    private final String customerName;
    private final Dish dish;
    private final PaymentStrategy paymentStrategy;
    private final int tableNumber;
    private final String note;

    OrderRequest(OrderBuilder builder) {
        this.customerName = builder.customerName;
        this.dish = builder.dish;
        this.paymentStrategy = builder.paymentStrategy;
        this.tableNumber = builder.tableNumber;
        this.note = builder.note;
    }

    public String getCustomerName() { return customerName; }
    public Dish getDish() { return dish; }
    public PaymentStrategy getPaymentStrategy() { return paymentStrategy; }
    public int getTableNumber() { return tableNumber; }
    public String getNote() { return note; }

    public boolean isTakeaway() { return tableNumber == 0; }

    @Override
    public String toString() {
        return "OrderRequest{customer='" + customerName + '\''
                + ", dish='" + dish.getDescription() + '\''
                + ", cost=" + dish.getCost() + " KZT"
                + ", payment='" + paymentStrategy.getName() + '\''
                + ", " + (isTakeaway() ? "takeaway" : "table=" + tableNumber)
                + (note.isEmpty() ? "" : ", note='" + note + '\'')
                + '}';
    }
}