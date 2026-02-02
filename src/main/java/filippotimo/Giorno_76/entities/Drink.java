package filippotimo.Giorno_76.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Drink extends ElementoMenu {
    private String size;

    public Drink(String name, long calories, double price, String size) {
        super(name, calories, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Drink { " +
                super.getName() +
                " (" + size +
                ") " +
                super.getCalories() +
                super.getPrice() +
                '}';
    }

}
