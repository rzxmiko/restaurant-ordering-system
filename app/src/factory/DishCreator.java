package factory;

public abstract class DishCreator {
    public abstract Dish createDish();

    public Dish orderDish() {
        return createDish();
    }
}