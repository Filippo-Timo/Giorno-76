package filippotimo.Giorno_76.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topping extends ElementoMenu {

    public Topping(String name, long calories, double price) {
        super(name, calories, price);
    }

    @Override
    public String toString() {
        return "Topping { " +
                super.toString() +
                '}';
    }

}
