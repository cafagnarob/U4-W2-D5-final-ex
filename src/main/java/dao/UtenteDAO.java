package dao;

import entities.Utente;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

public class UtenteDAO {
    private final EntityManager entityManager;

    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //save

    public void save(Utente newUtente) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newUtente);
        transaction.commit();
        System.out.println("L' utente " + newUtente + "è stato aggiungo al DB");
    }

    //find
    public Utente getById(Long id) {
        Utente fromDB = this.entityManager.find(Utente.class, id);
        if (fromDB == null) throw new NotFoundException(" utente non trovato");
        System.out.println("UTENTE RICHIESTO" + fromDB);
        return fromDB;

    }

    //find utente dalla tessera
    public Utente findByTessera(String tessera) {
        try {
            return entityManager.createQuery(
                            "SELECT u FROM Utente u WHERE u.numeroDitessera = :tessera",
                            Utente.class
                    )
                    .setParameter("tessera", tessera)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

    //delete
    public void delete(Long id) {
        Utente fromDB = this.getById(id);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.remove(fromDB);
        transaction.commit();
        System.out.println("L' utente " + fromDB + "è stato rimosso dal DB");
    }
}
