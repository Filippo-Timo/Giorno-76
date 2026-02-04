package filippotimo.Giorno_76;

import filippotimo.Giorno_76.entities.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
        System.out.println("Test 1");
        assertNotNull(margherita);
        assertNotNull(diavola);
        assertNull(fakePizza);
    }

    //    ---------------------------------- TEST 2 ----------------------------------

    @Test
    void testNotSamePizza() {
        System.out.println("Test 2");
        assertNotSame(margherita, diavola);
    }

    //    ---------------------------------- TEST 3 ----------------------------------

    @Test
    void testNameIsMargherita() {
        System.out.println("Test 3");
        assertEquals("Margherita pizza", margherita.getName());
        assertNotEquals("Margherita pizza", diavola.getName());
    }

    //    ---------------------------------- TEST 4 ----------------------------------

    @Test
    void testListSize() {
        System.out.println("Test 4");
        assertNotEquals(0, piattiOrdinati.size());
        assertNotEquals(1, piattiOrdinati.size());
        assertEquals(2, piattiOrdinati.size());
        assertNotEquals(3, piattiOrdinati.size());
    }

    //    ---------------------------------- TEST 5 (test di un metodo) ----------------------------------

    /*

    @ParameterizedTest
    @CsvSource({"5, 1.5, 17.48"})
    void testGetTotaleProdotti(int numCoperti, double costoCoperto, double expectedResult) {
        System.out.println("Test 5");
        double totale = (numCoperti * costoCoperto) + piattiOrdinati.stream().mapToDouble(ElementoMenu::getPrice).sum();
        assertEquals(expectedResult, totale);
    }

    */
    

    @Test
    void testGetTotaleProdotti() {
        System.out.println("Test 5");
        Table table = new Table(1, 10, StatoTavolo.occupato);
        Order order = new Order(1, table, piattiOrdinati, StatoOrdine.pronto, 5);
        double totale = order.getTotaleProdotti(1.5);
        assertEquals(17.48, totale);
    }

}
