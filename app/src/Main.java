import builder.OrderBuilder;
import builder.OrderRequest;
import decorator.CheeseDecorator;
import decorator.PepperoniDecorator;
import decorator.SauceDecorator;
import facade.RestaurantFacade;
import factory.BurgerCreator;
import factory.Dish;
import factory.DishCreator;
import factory.PastaCreator;
import factory.PizzaCreator;
import observer.CustomerObserver;
import observer.KitchenObserver;
import observer.Order;
import observer.OrderStatus;
import strategy.CardPayment;
import strategy.CashPayment;
import strategy.PaymentProcessor;
import strategy.PromoCodePayment;

public class Main {
    public static void main(String[] args) {
        DishCreator pizzaCreator = new PizzaCreator();
        DishCreator burgerCreator = new BurgerCreator();
        DishCreator pastaCreator = new PastaCreator();

        Dish pizza = pizzaCreator.orderDish();
        Dish burger = burgerCreator.orderDish();
        Dish pasta = pastaCreator.orderDish();

        print("Plain:", pizza);
        print("Plain:", burger);
        print("Plain:", pasta);

        Dish pizzaWithExtras = new PepperoniDecorator(new CheeseDecorator(pizza));
        Dish burgerWithExtras = new SauceDecorator(new CheeseDecorator(burger));
        Dish pastaWithSauce = new SauceDecorator(pasta);

        print("With extras:", pizzaWithExtras);
        print("With extras:", burgerWithExtras);
        print("With extras:", pastaWithSauce);

        // ===== Observer =====
        System.out.println("\n--- Observer ---");
        Order order = new Order(1, pizzaWithExtras);
        order.attach(new KitchenObserver());
        order.attach(new CustomerObserver("Zhanbota"));

        order.setStatus(OrderStatus.ACCEPTED);
        order.setStatus(OrderStatus.PREPARING);
        order.setStatus(OrderStatus.READY);

        // ===== Strategy =====
        System.out.println("\n--- Strategy ---");
        PaymentProcessor processor = new PaymentProcessor(new CashPayment());
        processor.pay(pizzaWithExtras.getCost());

        processor.setStrategy(new CardPayment());
        processor.pay(pizzaWithExtras.getCost());

        processor.setStrategy(new PromoCodePayment("WELCOME", 0.15));
        processor.pay(pizzaWithExtras.getCost());

        // ===== Builder =====
        System.out.println("\n--- Builder ---");
        OrderRequest dilaraOrder = new OrderBuilder()
                .customer("Dilara")
                .dish(new PizzaCreator())      // Factory
                .addCheese()                   // Decorator
                .addPepperoni()                // Decorator
                .payWith(new CardPayment())    // Strategy
                .table(5)
                .note("No onions, please")
                .build();
        System.out.println(dilaraOrder);

        OrderRequest zhanbotaOrder = new OrderBuilder()
                .customer("Zhanbota")
                .dish(new BurgerCreator())
                .addSauce()
                .payWith(new PromoCodePayment("WELCOME", 0.15))
                .build();
        System.out.println(zhanbotaOrder);

        OrderRequest quickOrder = new OrderBuilder()
                .customer("Guest")
                .dish(new PastaCreator())
                .build();
        System.out.println(quickOrder);

        try {
            new OrderBuilder().customer("Nobody").addCheese().build();
        } catch (IllegalStateException e) {
            System.out.println("Builder error: " + e.getMessage());
        }

        // ===== Facade =====
        System.out.println("\n--- Facade ---");
        RestaurantFacade restaurant = new RestaurantFacade();
        restaurant.placeOrder(dilaraOrder);
        restaurant.placeOrder(zhanbotaOrder);
        restaurant.placeOrder(quickOrder);
    }

    private static void print(String label, Dish dish) {
        System.out.println(label + " " + dish.getDescription() + " = " + dish.getCost() + " KZT");
    }
}