package filippotimo.Giorno_76;

import filippotimo.Giorno_76.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Giorno76Application {

    public static void main(String[] args) {

        SpringApplication.run(Giorno76Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Giorno76Application.class);

        Menu menu = ctx.getBean(Menu.class);
        System.out.println(menu);
    }

}
