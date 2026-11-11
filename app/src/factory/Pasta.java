package factory;

public class Pasta implements Dish {
    @Override
    public String getDescription() {
        return "Pasta";
    }

    @Override
    public double getCost() {
        return 2200.0;
    }
}