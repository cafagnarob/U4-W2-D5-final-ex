package dao;

import entities.Elemento;
import entities.Libro;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ElementoDAO {
    private final EntityManager entityManager;

    public ElementoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //save
    public void save(Elemento newElemento) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newElemento);
        transaction.commit();
        System.out.println("L' elemento " + newElemento + "è stato aggiungo al DB");
    }

    // find
    public Elemento getByISBN(String codiceISBN) {
        try {
            Elemento fromDB = this.entityManager.createQuery(
                            "SELECT e FROM Elemento e WHERE e.codiceISBN = :param",
                            Elemento.class
                    )
                    .setParameter("param", codiceISBN)
                    .getSingleResult();
            System.out.println("ELEMENTO RICHIESTO" + fromDB);
            return fromDB;
        } catch (NoResultException e) {
            throw new NotFoundException("Elemento non trovato con ISBN: " + codiceISBN);
        }
    }

    //delete
    public void delete(String codiceISBN) {
        Elemento fromDB = this.getByISBN(codiceISBN);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.remove(fromDB);
        transaction.commit();
        System.out.println("L' elemento " + fromDB + "è stato rimosso dal DB");
    }

    //ricerca per anno di pubblicazione
    public List<Elemento> ricercaPerAnno(int annoDiPubblicazione) {
        TypedQuery<Elemento> query = this.entityManager.createQuery(
                "SELECT e FROM Elemento e WHERE e.annoPubblicazione = :param", Elemento.class
        );
        query.setParameter("param", annoDiPubblicazione);
        System.out.println("LISTA ELEMENTI PUBBLICATI NEL" + annoDiPubblicazione + ": " + query.getResultList());
        return query.getResultList();
    }

    //ricerca per titolo o parte
    public List<Elemento> ricercaPerTitolo(String titolo) {
        List<Elemento> fromDB = this.entityManager.createQuery(
                        "SELECT e FROM Elemento e WHERE LOWER(e.titolo) LIKE LOWER(:param)", Elemento.class)
                .setParameter("param", "%" + titolo + "%").getResultList();
        if (fromDB.isEmpty()) throw new NotFoundException("titolo non trovato");
        System.out.println("ELEMENTO RICHIESTO" + fromDB);
        return fromDB;
    }


    //ricerca per autore
    public List<Libro> ricercaPerAutore(String autore) {

        TypedQuery<Libro> query = this.entityManager.createNamedQuery("Libro.ricercaPerAutore", Libro.class
        );
        query.setParameter("param", autore);
        List<Libro> res = query.getResultList();
        if (res.isEmpty()) {
            throw new NotFoundException("nessun autore trovato");
        }
        System.out.println("LISTA LIBRI PUBBLICATI DA" + autore + ": " + query.getResultList());
        return res;

    }


}
