package factory;

public class Burger implements Dish {
    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public double getCost() {
        return 1800.0;
    }
}