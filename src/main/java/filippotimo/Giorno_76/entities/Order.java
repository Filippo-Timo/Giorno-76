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

    private double importoTotale;


    public Order(int numeroOrdine, Table tavolo, List<ElementoMenu> piattiOrdinati, StatoOrdine statoOrdine, int numCoperti, double prezzoSingoloCoperto) {
        this.numeroOrdine = numeroOrdine;
        this.tavolo = tavolo;
        this.piattiOrdinati = piattiOrdinati;
        this.statoOrdine = statoOrdine;
        this.numCoperti = numCoperti;
        this.orario = LocalTime.now();
        double totalePrezziPiatti = piattiOrdinati.stream().mapToDouble(ElementoMenu::getPrice).sum();
        this.importoTotale = (numCoperti * prezzoSingoloCoperto) + totalePrezziPiatti;
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
                ", importoTotale = " + importoTotale +
                '}';
    }
}
