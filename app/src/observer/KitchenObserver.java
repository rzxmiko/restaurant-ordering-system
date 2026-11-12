package observer;

public class KitchenObserver implements OrderObserver {
    @Override
    public void update(Order order, OrderStatus status) {
        System.out.println("[Кухня] Заказ #" + order.getId()
                + " (" + order.getDish().getDescription() + "): " + status.getTitle());
    }
}