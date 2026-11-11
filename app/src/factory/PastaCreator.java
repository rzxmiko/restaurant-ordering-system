package factory;

public class PastaCreator extends DishCreator {
    @Override
    public Dish createDish() {
        return new Pasta();
    }
}