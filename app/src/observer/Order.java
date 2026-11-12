package observer;

import factory.Dish;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private final Dish dish;
    private OrderStatus status;
    private final List<OrderObserver> observers = new ArrayList<>();

    public Order(int id, Dish dish) {
        this.id = id;
        this.dish = dish;
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this, status);
        }
    }

    public int getId() { return id; }
    public Dish getDish() { return dish; }
    public OrderStatus getStatus() { return status; }
}