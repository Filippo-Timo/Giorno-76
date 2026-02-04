package filippotimo.Giorno_76.runners;

import filippotimo.Giorno_76.Giorno76Application;
import filippotimo.Giorno_76.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Giorno76Application.class);

        System.out.println("Ciao, siamo nel Runner");

        System.out.println("----------------------- Menu -----------------------");
        Menu menu = ctx.getBean(Menu.class);
        System.out.println(menu);


        Table table = new Table(1, 10, StatoTavolo.occupato);


        ElementoMenu margherita = ctx.getBean("getMargheritaPizza", ElementoMenu.class);
        ElementoMenu diavola = ctx.getBean("getDiavolaPizza", ElementoMenu.class);
        ElementoMenu acqua = ctx.getBean("getWater", ElementoMenu.class);


//        List<ElementoMenu> piattiOrdinati = new ArrayList<>(
//                List.of(margherita, diavola, acqua)
//        );

        double coperto = ctx.getBean("getPrezzoSingoloCoperto", Double.class);
        System.out.println("---------------------- Ordine ----------------------");
        Order order = new Order(1, table, new ArrayList<>(List.of(margherita, diavola, acqua)), StatoOrdine.pronto, 5);
        System.out.println("Ordine: " + order);
        System.out.println("------------- Prezzo singolo coperto --------------");
        System.out.println(coperto);
        System.out.println("---------------------- Totale ----------------------");
        double totale = order.getTotaleProdotti(coperto);
        System.out.println("Totale ordine: " + totale + " €");


        System.out.println("Arrivederci dal Runner");

    }
}
