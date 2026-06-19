package dao;

import entities.Elemento;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
        Elemento fromDB = this.entityManager.find(Elemento.class, id);
        if (fromDB == null) throw new NotFoundException(" elemento non trovato");
        System.out.println("ELEMENTO RICHIESTO" + fromDB);
        return fromDB;

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
    public List<Elemento> listaRicercaPerAnno(int annoDiPubblicazione) {
        
    }
}
