package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "elemento_a_catalogo")
// la scelta di JOINED è dovuta alla volontà di ottenere tre tabella di facile gestione:
// tabella elemento_a_catalogo
// tabella libro
// tabella rivista
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codiceISBN;

    @Column(nullable = false)
    private String titolo;

    @Column(nullable = false)
    private int annoPubblicazione;

    @Column(nullable = false)
    private int numeroPagine;

    protected Elemento() {

    }

    public Elemento(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public Long getId() {
        return id;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    @Override
    public String toString() {
        return "Elemento{ \n" +
                "id=" + id + "\n" +
                ", codiceISBN='" + codiceISBN + "\n" +
                ", titolo='" + titolo + "\n" +
                ", annoPubblicazione=" + annoPubblicazione + "\n" +
                ", numeroPagine=" + numeroPagine + "\n" +
                "} \n";
    }
}
