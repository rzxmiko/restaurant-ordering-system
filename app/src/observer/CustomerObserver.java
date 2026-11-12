package observer;

public class CustomerObserver implements OrderObserver {
    private final String customerName;

    public CustomerObserver(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(Order order, OrderStatus status) {
        System.out.println("[Клиент " + customerName + "] Ваш заказ #" + order.getId()
                + " теперь: " + status.getTitle());
    }
}