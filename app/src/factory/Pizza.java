package factory;

public class Pizza implements Dish {
    @Override
    public String getDescription() {
        return "Pizza";
    }

    @Override
    public double getCost() {
        return 2500.0;
    }
}