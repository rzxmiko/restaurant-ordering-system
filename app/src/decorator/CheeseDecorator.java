package decorator;

import factory.Dish;

public class CheeseDecorator extends DishDecorator {
    public CheeseDecorator(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + " + Extra Cheese";
    }

    @Override
    public double getCost() {
        return dish.getCost() + 300.0;
    }
}