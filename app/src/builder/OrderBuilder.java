package builder;

import decorator.CheeseDecorator;
import decorator.PepperoniDecorator;
import decorator.SauceDecorator;
import factory.Dish;
import factory.DishCreator;
import strategy.CashPayment;
import strategy.PaymentStrategy;


public class OrderBuilder {
    String customerName;
    Dish dish;
    PaymentStrategy paymentStrategy = new CashPayment();
    int tableNumber = 0;
    String note = "";

    public OrderBuilder customer(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public OrderBuilder dish(DishCreator creator) {
        this.dish = creator.orderDish();
        return this;
    }

    public OrderBuilder addCheese() {
        requireDish();
        this.dish = new CheeseDecorator(dish);
        return this;
    }

    public OrderBuilder addPepperoni() {
        requireDish();
        this.dish = new PepperoniDecorator(dish);
        return this;
    }

    public OrderBuilder addSauce() {
        requireDish();
        this.dish = new SauceDecorator(dish);
        return this;
    }

    public OrderBuilder payWith(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        return this;
    }

    public OrderBuilder table(int tableNumber) {
        this.tableNumber = tableNumber;
        return this;
    }

    public OrderBuilder note(String note) {
        this.note = note;
        return this;
    }

    public OrderRequest build() {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalStateException("Customer name is required");
        }
        requireDish();
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment method is required");
        }
        if (tableNumber < 0) {
            throw new IllegalStateException("Table number cannot be negative");
        }
        return new OrderRequest(this);
    }

    private void requireDish() {
        if (dish == null) {
            throw new IllegalStateException("Choose a dish first: call dish(...) before adding toppings");
        }
    }
}