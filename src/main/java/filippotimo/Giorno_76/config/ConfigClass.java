package filippotimo.Giorno_76.config;

import filippotimo.Giorno_76.entities.Drink;
import filippotimo.Giorno_76.entities.Pizza;
import filippotimo.Giorno_76.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConfigClass {

    //    ----------------------------------- Ingredienti -----------------------------------

    @Bean
    public Topping getTomato() {
        return new Topping("tomato", 50, 0.50);
    }

    @Bean
    public Topping getCheese() {
        return new Topping("cheese", 150, 0.50);
    }

    @Bean
    public Topping getHam() {
        return new Topping("ham", 80, 0.99);
    }

    @Bean
    public Topping getOnions() {
        return new Topping("ham", 30, 0.50);
    }

    @Bean
    public Topping getPinapple() {
        return new Topping("pinapple", 120, 0.70);
    }

    @Bean
    public Topping getSalami() {
        return new Topping("salami", 210, 0.99);
    }

    //    ----------------------------------- Pizze -----------------------------------

    @Bean
    public Pizza getMargheritaPizza() {
        return new Pizza("Margherita pizza", 1104, 4.99, List.of(getTomato(), getCheese()));
    }

    @Bean
    public Pizza getHawaiianPizza() {
        return new Pizza("Hawaiian pizza", 1024, 6.49, List.of(getTomato(), getCheese(), getPinapple()));
    }

    @Bean
    public Pizza getSalamiPizza() {
        return new Pizza("Salami pizza", 1160, 5.99, List.of(getTomato(), getCheese(), getSalami()));
    }

    @Bean
    public Pizza getDiavolaPizza() {
        return new Pizza("Diavola pizza", 1230, 4.99, List.of(getTomato(), getCheese(), getSalami()));
    }

    //    ----------------------------------- Bevande -----------------------------------

    @Bean
    public Drink getWater() {
        return new Drink("Water", 0, 1, "0.5l");
    }

    @Bean
    public Drink getLemonade() {
        return new Drink("Lemonade", 128, 1.50, "0.33l");
    }

    @Bean
    public Drink getWine() {
        return new Drink("Wine", 607, 7.50, "0.75l, 13%");
    }

    //    ----------------------------------- Costruzione Menù -----------------------------------

//    @Bean
//    public Menu getMenu() {
//        return new Menu(
//                List.of(getMargheritaPizza(), getHawaiianPizza(), getSalamiPizza()),
//                List.of(getTomato(), getCheese(), getHam(), getOnions(), getPinapple(), getSalami()),
//                List.of(getWater(), getLemonade(), getWine())
//        );
//    }

//    @Bean
//    public double getPrezzoSingoloCoperto(@Value("${price.coperto}") double priceCoperto) {
//        return priceCoperto;
//    }

}
