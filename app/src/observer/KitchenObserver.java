package observer;

public class KitchenObserver implements OrderObserver {
    @Override
    public void update(Order order, OrderStatus status) {
        System.out.println("[Kitchen] Order #" + order.getId()
                + " (" + order.getDish().getDescription() + "): " + status.getTitle());
    }
}