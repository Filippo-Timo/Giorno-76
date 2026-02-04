package filippotimo.Giorno_76;

import filippotimo.Giorno_76.entities.ElementoMenu;
import filippotimo.Giorno_76.entities.Pizza;
import filippotimo.Giorno_76.entities.Topping;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    Pizza fakePizza = null;

    //    ---------------------------------- BEFOREALL / AFTERALL ----------------------------------

    @BeforeAll
    static void beforeEveryTest() {
        System.out.println("Inizio nuovo Test");
    }

    @AfterAll
    static void afterEveryTest() {
        System.out.println("Fine precedente Test");
    }

    //    ---------------------------------- TEST 1 ----------------------------------

    @Test
    void testObjNullOrNotNull() {
        assertNotNull(margherita);
        assertNotNull(diavola);
        assertNull(fakePizza);
    }

    //    ---------------------------------- TEST 2 ----------------------------------

    @Test
    void testNotSamePizza() {
        assertNotSame(margherita, diavola);
    }

    //    ---------------------------------- TEST 3 ----------------------------------

    @Test
    void testNameIsMargherita() {
        assertEquals("Margherita pizza", margherita.getName());
        assertNotEquals("Margherita pizza", diavola.getName());
    }

    //    ---------------------------------- TEST 4 ----------------------------------

    @Test
    void testListSize() {
        assertNotEquals(0, piattiOrdinati.size());
        assertNotEquals(1, piattiOrdinati.size());
        assertEquals(2, piattiOrdinati.size());
        assertNotEquals(3, piattiOrdinati.size());
    }

    //    ---------------------------------- TEST 5 (test di un metodo) ----------------------------------

    @ParameterizedTest
    @CsvSource({"5, 1.5, 17.48"})
    void testGetTotaleProdotti(int numCoperti, double costoCoperto, double expectedResult) {
        double totale = (numCoperti * costoCoperto) + piattiOrdinati.stream().mapToDouble(ElementoMenu::getPrice).sum();
        assertEquals(expectedResult, totale);
    }

}
