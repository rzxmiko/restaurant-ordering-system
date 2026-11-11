import decorator.CheeseDecorator;
import decorator.PepperoniDecorator;
import decorator.SauceDecorator;
import factory.BurgerCreator;
import factory.Dish;
import factory.DishCreator;
import factory.PastaCreator;
import factory.PizzaCreator;

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
    }

    private static void print(String label, Dish dish) {
        System.out.println(label + " " + dish.getDescription() + " = " + dish.getCost() + " KZT");
    }
}