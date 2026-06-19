package dao;

import entities.Prestito;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitoDAO {
    private final EntityManager entityManager;

    public PrestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //save

    public void save(Prestito newPrestito) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newPrestito);
        transaction.commit();
        System.out.println("il prestito " + newPrestito + "è stato aggiungo al DB");
    }

    //find
    public Prestito getById(Long id) {
        Prestito fromDB = this.entityManager.find(Prestito.class, id);
        if (fromDB == null) throw new NotFoundException(" prestito non trovato");
        System.out.println("PRESTITO RICHIESTO" + fromDB);
        return fromDB;

    }

    //delete
    public void delete(Long id) {
        Prestito fromDB = this.getById(id);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.remove(fromDB);
        transaction.commit();
        System.out.println("il prestito " + fromDB + "è stato rimosso dal DB");
    }
}
