package filippotimo.Giorno_76;

import filippotimo.Giorno_76.entities.ElementoMenu;
import filippotimo.Giorno_76.entities.Pizza;
import filippotimo.Giorno_76.entities.Topping;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Giorno76ApplicationTests {

    //    ---------------------------------- CREO GLI OGGETTI TOPPINGS ----------------------------------
    Topping tomato = new Topping("tomato", 50, 0.50);
    Topping cheese = new Topping("cheese", 150, 0.50);

    //    ---------------------------------- CREO L'OGGETTO MARGHERITA ----------------------------------
    List<Topping> toppingsMargerita = new ArrayList<>(
            List.of(tomato, cheese)
    );

    Pizza margherita = new Pizza("Margherita pizza", 1104, 4.99, toppingsMargerita);
    Topping salami = new Topping("salami", 210, 0.99);
    //    ---------------------------------- CREO L'OGGETTO DIAVOLA ----------------------------------
    List<Topping> toppingsDiavola = new ArrayList<>(
            List.of(tomato, cheese, salami)
    );
    Pizza diavola = new Pizza("Diavola pizza", 1230, 4.99, toppingsDiavola);
    //    ---------------------------------- CREO LA LISTA ----------------------------------
    List<ElementoMenu> piattiOrdinati = new ArrayList<>(
            List.of(margherita, diavola)
    );

    //    ---------------------------------- BEFOREALL / AFTERALL ----------------------------------

    @BeforeAll
    static void beforeEveryTest() {
        System.out.println("Inizio nuovo Test");
    }

    @AfterAll
    static void afterEveryTest() {
        System.out.println("Fine precedente Test");
    }

    //    ---------------------------------- TEST METODO 1 ----------------------------------

    //    ---------------------------------- TEST METODO 2 ----------------------------------

    //    ---------------------------------- TEST METODO 3 ----------------------------------

    //    ---------------------------------- TEST METODO 4 ----------------------------------

    //    ---------------------------------- TEST METODO 5 ----------------------------------
    @ParameterizedTest
    @CsvSource({"5, 1.5, 17.48"})
    void testGetTotaleProdotti(int numCoperti, double costoCoperto, double expectedResult) {
        double totale = (numCoperti * costoCoperto) + piattiOrdinati.stream().mapToDouble(ElementoMenu::getPrice).sum();
        assertEquals(expectedResult, totale);
    }

}
