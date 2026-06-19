package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "elemento_id")
    private Elemento elementoPrestato;

    @Column(nullable = false)
    private LocalDate dataInizioPrestito;

    @Column(nullable = false)
    private LocalDate dataRestituzionePrevista;

    @Column
    private LocalDate dataRestituzioneEffettiva;


    protected Prestito() {

    }

    public Prestito(Utente utente, Elemento elementoPrestato,
                    LocalDate dataInizioPrestito,
                    LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = null;
    }

    public Long getId() {
        return id;
    }

    public Elemento getElementoPrestato() {
        return elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public LocalDate getGetDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setGetDataRestituzioneEffettiva(LocalDate getDataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = getDataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{ \n" +
                "id=" + id + "\n" +
                ", utente=" + utente + "\n" +
                ", elementoPrestato=" + elementoPrestato + "\n" +
                ", dataInizioPrestito=" + dataInizioPrestito + "\n" +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista + "\n" +
                ", getDataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "\n" +
                "} \n";
    }
}

