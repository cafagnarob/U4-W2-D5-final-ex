package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Libro.ricercaPerAutore",
                query = "SELECT l FROM Libro l WHERE l.autore = :param"
        )
})
public class Libro extends Elemento {
    @Column(nullable = false)
    private String autore;

    @Column(nullable = false)
    private String genere;

    protected Libro() {
    }

    public Libro(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine,
                 String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;

    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Libro{ \n" +
                "autore='" + autore + "\n" +
                ", genere='" + genere + "\n" +
                "} " + super.toString();
    }
}
