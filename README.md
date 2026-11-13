# Restaurant Ordering System

Final project for the **Software Design Patterns** course.
A console Java application that implements a restaurant ordering process using six design patterns.

## Team

| Member | Patterns |
| --- | --- |
| Dilara | Factory Method, Decorator |
| Zhanbota | Observer, Strategy |
| [Your name] | Builder, Facade |

## Patterns

| Pattern | Package | Purpose |
| --- | --- | --- |
| Factory Method | `factory` | Creates dishes: Pizza, Burger, Pasta |
| Decorator | `decorator` | Adds toppings: cheese, pepperoni, sauce |
| Observer | `observer` | Notifies kitchen and customer about order status |
| Strategy | `strategy` | Payment methods: cash, card, promo code |
| Builder | `builder` | Builds an order step by step |
| Facade | `facade` | Runs the whole order process with one method |

## Project structure

```
app/src/
├── builder/     OrderBuilder, OrderRequest
├── decorator/   DishDecorator, CheeseDecorator, PepperoniDecorator, SauceDecorator
├── facade/      RestaurantFacade
├── factory/     Dish, Pizza, Burger, Pasta, DishCreator, PizzaCreator, BurgerCreator, PastaCreator
├── observer/    Order, OrderObserver, KitchenObserver, CustomerObserver, OrderStatus
├── strategy/    PaymentStrategy, CashPayment, CardPayment, PromoCodePayment, PaymentProcessor
└── Main.java    demo of all patterns
```
