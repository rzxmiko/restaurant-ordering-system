package factory;

public class PizzaCreator extends DishCreator {
    @Override
    public Dish createDish() {
        return new Pizza();
    }
}