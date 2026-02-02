package filippotimo.Giorno_76.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pizza extends ElementoMenu {

    private List<Topping> toppings;

    public Pizza(String name, long calories, double price, List<Topping> toppings) {
        super(name, calories, price);
        this.toppings = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Pizza { " +
                super.toString() +
                "toppings = ( " + toppings +
                " ) " +
                '}';
    }

}
