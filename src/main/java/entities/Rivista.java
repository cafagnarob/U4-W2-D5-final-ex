package entities;

import Enum.Periodicita;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Rivista extends Elemento {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Periodicita periodicita;

    protected Rivista() {
    }

    public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine,
                   Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicità() {
        return periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{ \n" +
                "periodicità=" + periodicita + "\n" +
                "} " + super.toString();
    }
}
