package filippotimo.Giorno_76.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElementoMenu {

    private String name;
    private long calories;
    private double price;

    public ElementoMenu(String name, long calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ElementoMenu { " +
                "name = " + name +
                ", calories = " + calories +
                ", price = " + price +
                '}';
    }
}
