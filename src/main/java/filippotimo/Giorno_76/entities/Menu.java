package filippotimo.Giorno_76.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class Menu {

    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Drink> drinks;

    @Autowired
    public Menu(List<Pizza> pizzas, List<Topping> toppings, List<Drink> drinks) {
        this.pizzas = pizzas;
        this.toppings = toppings;
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "Menu { " +
                "pizzas = (" + pizzas +
                "), toppings = (" + toppings +
                "), drinks = (" + drinks +
                ") " +
                '}';
    }
}
