package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private LocalDate dataDiNascita;

    @Column(unique = true, nullable = false)
    private String numeroDitessera;

    protected Utente() {

    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita, String numeroDitessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroDitessera = numeroDitessera;
    }

    public Long getId() {
        return id;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public String getNumeroDitessera() {
        return numeroDitessera;
    }

    @Override
    public String toString() {
        return "Utente{ \n" +
                "id=" + id + "\n" +
                ", nome='" + nome + '\'' + "\n" +
                ", cognome='" + cognome + '\'' + "\n" +
                ", dataDiNascita=" + dataDiNascita + "\n" +
                ", numeroDitessera='" + numeroDitessera + "\n" +
                "} \n";
    }
}
