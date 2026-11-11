package decorator;

import factory.Dish;

public class PepperoniDecorator extends DishDecorator {
    public PepperoniDecorator(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + " + Pepperoni";
    }

    @Override
    public double getCost() {
        return dish.getCost() + 450.0;
    }
}