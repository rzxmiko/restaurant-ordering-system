package decorator;

import factory.Dish;

public class SauceDecorator extends DishDecorator {
    public SauceDecorator(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + " + Special Sauce";
    }

    @Override
    public double getCost() {
        return dish.getCost() + 200.0;
    }
}