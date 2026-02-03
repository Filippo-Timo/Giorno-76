package filippotimo.Giorno_76.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table {

    private int numeroTavolo;

    private int numCopertiMax;

    private StatoTavolo statoTavolo;

    public Table(int numeroTavolo, int numCopertiMax, StatoTavolo statoTavolo) {
        this.numeroTavolo = numeroTavolo;
        this.numCopertiMax = numCopertiMax;
        this.statoTavolo = statoTavolo;
    }

    @Override
    public String toString() {
        return "Table { " +
                "numeroTavolo = " + numeroTavolo +
                ", numCopertiMax = " + numCopertiMax +
                ", statoTavolo = " + statoTavolo +
                '}';
    }
}
