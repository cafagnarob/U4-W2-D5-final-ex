package dao;

import entities.Elemento;
import entities.Prestito;
import entities.Utente;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    // ricerca elementi in prestito da numero di tessera
    public List<Elemento> elementiInPrestitoPerTessera(String tessera) {
        UtenteDAO utenteDAO = new UtenteDAO(entityManager);
        Utente fromDB = utenteDAO.findByTessera(tessera);
        if (fromDB == null) {
            throw new NotFoundException("Tessera non valida: " + tessera);
        }
        TypedQuery<Elemento> query = this.entityManager.createQuery(
                "SELECT p.elementoPrestato " +
                        "FROM Prestito p " +
                        "WHERE p.utente = :param " +
                        "AND p.dataRestituzioneEffettiva IS NULL",
                Elemento.class
        );
        query.setParameter("param", fromDB);
        System.out.println("LISTA PRESTITI ATTIVI DI " + tessera + ": " + query.getResultList());
        return query.getResultList();

    }

    //ricerca prestriti scaduti e non restituiti
    public List<Prestito> prestitiScaduti() {
        TypedQuery<Prestito> query = this.entityManager.createQuery(
                "SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE " +
                        "AND p.dataRestituzioneEffettiva IS NULL", Prestito.class
        );
        System.out.println("LISTA PRESTITI SCADUTI NON RESTITUITI : " + query.getResultList());
        return query.getResultList();
    }


}
