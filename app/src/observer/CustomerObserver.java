package observer;

public class CustomerObserver implements OrderObserver {
    private final String customerName;

    public CustomerObserver(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(Order order, OrderStatus status) {
        System.out.println("[Customer " + customerName + "] Your order #" + order.getId()
                + " is now: " + status.getTitle());
    }
}