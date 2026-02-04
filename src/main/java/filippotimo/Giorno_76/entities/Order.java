package filippotimo.Giorno_76.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class Order {

    private int numeroOrdine;

    private Table tavolo;

    private List<ElementoMenu> piattiOrdinati;

    private StatoOrdine statoOrdine;

    private int numCoperti;

    private LocalTime orario;


    public Order(int numeroOrdine, Table tavolo, List<ElementoMenu> piattiOrdinati, StatoOrdine statoOrdine, int numCoperti) {
        this.numeroOrdine = numeroOrdine;
        this.tavolo = tavolo;
        this.piattiOrdinati = piattiOrdinati;
        this.statoOrdine = statoOrdine;
        this.numCoperti = numCoperti;
        this.orario = LocalTime.now();
//        this.importoTotale = (numCoperti * 1.50) + getTotaleProdotti(piattiOrdinati);
    }

//    public double getTotaleProdotti(List<ElementoMenu> piattiOrdinati) {
//        double totale = piattiOrdinati.stream().mapToDouble(ElementoMenu::getPrice).sum();
//        return totale;
//    }

    public double getTotaleProdotti(double costoCoperto) {
        double totale = (numCoperti * costoCoperto) + piattiOrdinati.stream().mapToDouble(ElementoMenu::getPrice).sum();
        return totale;
    }

    @Override
    public String toString() {
        return "Order { " +
                "numeroOrdine = " + numeroOrdine +
                ", tavolo = " + tavolo +
                ", piattiOrdinati = " + piattiOrdinati +
                ", statoOrdine = " + statoOrdine +
                ", numCoperti = " + numCoperti +
                ", orario = " + orario +
                '}';
    }
}
