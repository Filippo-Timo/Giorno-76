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

        System.out.println("Questo è il menù:");
        Menu menu = ctx.getBean(Menu.class);
        System.out.println(menu);

        Table table = new Table(1, 10, StatoTavolo.occupato);
        ElementoMenu margherita = ctx.getBean("getMargheritaPizza", ElementoMenu.class);
        ElementoMenu diavola = ctx.getBean("getDiavolaPizza", ElementoMenu.class);
        ElementoMenu acqua = ctx.getBean("getWater", ElementoMenu.class);

        List<ElementoMenu> piattiOrdinati = new ArrayList<>(
                List.of(margherita, diavola, acqua)
        );
        
        Order order = new Order(1, table, piattiOrdinati, StatoOrdine.pronto, 5, 1.50);
        System.out.println("Order: " + order);


        System.out.println("Questa è la fine del Runner");

    }
}
