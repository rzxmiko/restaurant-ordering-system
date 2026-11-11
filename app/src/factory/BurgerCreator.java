package factory;

public class BurgerCreator extends DishCreator {
    @Override
    public Dish createDish() {
        return new Burger();
    }
}