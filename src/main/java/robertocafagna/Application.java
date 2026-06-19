package robertocafagna;

import dao.ElementoDAO;
import dao.PrestitoDAO;
import dao.UtenteDAO;
import entities.Elemento;
import entities.Prestito;
import entities.Utente;
import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4-w3-d5pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ElementoDAO elementoDAO = new ElementoDAO(entityManager);
        PrestitoDAO prestitoDAO = new PrestitoDAO(entityManager);
        UtenteDAO utenteDAO = new UtenteDAO(entityManager);

        // UTENTE
        /*Utente u1 = new Utente("Mario", "Rossi", LocalDate.of(1995, 3, 12), "TESS001");
        Utente u2 = new Utente("Luca", "Bianchi", LocalDate.of(1988, 7, 21), "TESS002");
        Utente u3 = new Utente("Giulia", "Verdi", LocalDate.of(2000, 1, 5), "TESS003");
        Utente u4 = new Utente("Andrea", "Colombo", LocalDate.of(1992, 11, 30), "TESS004");
        Utente u5 = new Utente("Sara", "Ferrari", LocalDate.of(1998, 6, 18), "TESS005");
        Utente u6 = new Utente("Francesco", "Russo", LocalDate.of(1985, 9, 9), "TESS006");
        Utente u7 = new Utente("Elena", "Romano", LocalDate.of(1993, 4, 27), "TESS007");
        Utente u8 = new Utente("Davide", "Gallo", LocalDate.of(1997, 12, 14), "TESS008");
        Utente u9 = new Utente("Martina", "Conti", LocalDate.of(2001, 8, 2), "TESS009");
        Utente u10 = new Utente("Alessandro", "Greco", LocalDate.of(1990, 5, 19), "TESS010");


        utenteDAO.save(u1);
        utenteDAO.save(u2);
        utenteDAO.save(u3);
        utenteDAO.save(u4);
        utenteDAO.save(u5);
        utenteDAO.save(u6);
        utenteDAO.save(u7);
        utenteDAO.save(u8);
        utenteDAO.save(u9);
        utenteDAO.save(u10);*/

        //prendo gli utenti dal DB
        System.out.println("----RECUPERO GLI UTENTI DAL DB-------");
        Utente u1FromDB = null;
        Utente u2FromDB = null;
        Utente u3FromDB = null;
        Utente u4FromDB = null;
        Utente u5FromDB = null;
        Utente u6FromDB = null;
        Utente u7FromDB = null;
        Utente u8FromDB = null;
        Utente u9FromDB = null;
        Utente u10FromDB = null;
        

        try {
            u1FromDB = utenteDAO.getById(1L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            u2FromDB = utenteDAO.getById(2L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            u3FromDB = utenteDAO.getById(3L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            u4FromDB = utenteDAO.getById(4L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            u5FromDB = utenteDAO.getById(5L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            u6FromDB = utenteDAO.getById(6L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            u7FromDB = utenteDAO.getById(7L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            u8FromDB = utenteDAO.getById(8L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            u9FromDB = utenteDAO.getById(9L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            u10FromDB = utenteDAO.getById(10L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        // LIBRI
        /*Libro l1 = new Libro("ISBN001", "Il nome della rosa", 1980, 500, "Umberto Eco", "Storico");
        Libro l2 = new Libro("ISBN002", "1984", 1949, 328, "George Orwell", "Distopico");
        Libro l3 = new Libro("ISBN003", "Il piccolo principe", 1943, 96, "Antoine de Saint-Exupéry", "Fiaba");
        Libro l4 = new Libro("ISBN004", "La divina commedia", 1320, 700, "Dante Alighieri", "Classico");
        Libro l5 = new Libro("ISBN005", "Harry Potter e la pietra filosofale", 1997, 320, "J.K. Rowling", "Fantasy");
        Libro l6 = new Libro("ISBN006", "Il signore degli anelli", 1954, 1200, "J.R.R. Tolkien", "Fantasy");
        Libro l7 = new Libro("ISBN007", "Orgoglio e pregiudizio", 1813, 432, "Jane Austen", "Romantico");
        Libro l8 = new Libro("ISBN008", "Dune", 1965, 688, "Frank Herbert", "Sci-fi");
        Libro l9 = new Libro("ISBN009", "Fahrenheit 451", 1953, 249, "Ray Bradbury", "Distopico");
        Libro l10 = new Libro("ISBN010", "Il cacciatore di aquiloni", 2003, 371, "Khaled Hosseini", "Narrativo");

        elementoDAO.save(l1);
        elementoDAO.save(l2);
        elementoDAO.save(l3);
        elementoDAO.save(l4);
        elementoDAO.save(l5);
        elementoDAO.save(l6);
        elementoDAO.save(l7);
        elementoDAO.save(l8);
        elementoDAO.save(l9);
        elementoDAO.save(l10);*/


        //RIVISTA
       /* Rivista r1 = new Rivista("MAG001", "National Geographic", 2024, 120, Periodicita.MENSILE);
        Rivista r2 = new Rivista("MAG002", "Science Weekly", 2025, 80, Periodicita.SETTIMANALE);
        Rivista r3 = new Rivista("MAG003", "Focus", 2023, 100, Periodicita.MENSILE);
        Rivista r4 = new Rivista("MAG004", "Time Magazine", 2024, 90, Periodicita.SETTIMANALE);
        Rivista r5 = new Rivista("MAG005", "Wired", 2025, 110, Periodicita.MENSILE);
        Rivista r6 = new Rivista("MAG006", "Nature Today", 2024, 70, Periodicita.SETTIMANALE);
        Rivista r7 = new Rivista("MAG007", "Economy Review", 2023, 95, Periodicita.SEMESTRALE);
        Rivista r8 = new Rivista("MAG008", "Tech Monthly", 2025, 130, Periodicita.MENSILE);
        Rivista r9 = new Rivista("MAG009", "History Digest", 2022, 85, Periodicita.SEMESTRALE);
        Rivista r10 = new Rivista("MAG010", "Art & Culture", 2024, 75, Periodicita.MENSILE);
*/
        /*elementoDAO.save(r1);
        elementoDAO.save(r2);
        elementoDAO.save(r3);
        elementoDAO.save(r4);
        elementoDAO.save(r5);
        elementoDAO.save(r6);
        elementoDAO.save(r7);
        elementoDAO.save(r8);
        elementoDAO.save(r9);
        elementoDAO.save(r10);
*/

        //prendo i libri e le riviste dal DB
        //LIBRI
        System.out.println("----RECUPERO I LIBRI DAL DB-------");
        Elemento l1FromDB = null;
        Elemento l2FromDB = null;
        Elemento l3FromDB = null;
        Elemento l4FromDB = null;
        Elemento l5FromDB = null;
        Elemento l6FromDB = null;
        Elemento l7FromDB = null;
        Elemento l8FromDB = null;
        Elemento l9FromDB = null;
        Elemento l10FromDB = null;


        try {
            l1FromDB = elementoDAO.getByISBN("ISBN001");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            l2FromDB = elementoDAO.getByISBN("ISBN002");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            l3FromDB = elementoDAO.getByISBN("ISBN003");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            l4FromDB = elementoDAO.getByISBN("ISBN004");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            l5FromDB = elementoDAO.getByISBN("ISBN005");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            l6FromDB = elementoDAO.getByISBN("ISBN006");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            l7FromDB = elementoDAO.getByISBN("ISBN007");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            l8FromDB = elementoDAO.getByISBN("ISBN008");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            l9FromDB = elementoDAO.getByISBN("ISBN009");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            l10FromDB = elementoDAO.getByISBN("ISBN010");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }


        //riviste
        System.out.println("----RECUPERO LE RIVISTE DAL DB-------");

        Elemento r1FromDB = null;
        Elemento r2FromDB = null;
        Elemento r3FromDB = null;
        Elemento r4FromDB = null;
        Elemento r5FromDB = null;
        Elemento r6FromDB = null;
        Elemento r7FromDB = null;
        Elemento r8FromDB = null;
        Elemento r9FromDB = null;
        Elemento r10FromDB = null;

        try {
            r1FromDB = elementoDAO.getByISBN("MAG001");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            r2FromDB = elementoDAO.getByISBN("MAG002");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            r3FromDB = elementoDAO.getByISBN("MAG003");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            r4FromDB = elementoDAO.getByISBN("MAG004");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            r5FromDB = elementoDAO.getByISBN("MAG005");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            r6FromDB = elementoDAO.getByISBN("MAG006");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            r7FromDB = elementoDAO.getByISBN("MAG007");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            r8FromDB = elementoDAO.getByISBN("MAG008");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            r9FromDB = elementoDAO.getByISBN("MAG009");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            r10FromDB = elementoDAO.getByISBN("MAG010");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }


        // PRESTITI

        Prestito p1 = new Prestito(u1FromDB, l1FromDB, LocalDate.of(2026, 5, 10), null);
        Prestito p2 = new Prestito(u2FromDB, l2FromDB, LocalDate.of(2026, 5, 15), null);
        Prestito p3 = new Prestito(u3FromDB, l3FromDB, LocalDate.of(2026, 4, 20), LocalDate.of(2026, 5, 5));
        Prestito p4 = new Prestito(u4FromDB, l4FromDB, LocalDate.of(2026, 6, 1), null);
        Prestito p5 = new Prestito(u5FromDB, r1FromDB, LocalDate.of(2026, 3, 10), LocalDate.of(2026, 4, 2));

        Prestito p6 = new Prestito(u6FromDB, r2FromDB, LocalDate.of(2026, 5, 1), null);
        Prestito p7 = new Prestito(u7FromDB, l5FromDB, LocalDate.of(2026, 2, 14), LocalDate.of(2026, 3, 10));
        Prestito p8 = new Prestito(u8FromDB, r3FromDB, LocalDate.of(2026, 6, 10), null);
        Prestito p9 = new Prestito(u9FromDB, l6FromDB, LocalDate.of(2026, 4, 28), LocalDate.of(2026, 5, 20));
        Prestito p10 = new Prestito(u10FromDB, r4FromDB, LocalDate.of(2026, 6, 5), null);
        /*prestitoDAO.save(p1);
        prestitoDAO.save(p2);
        prestitoDAO.save(p3);
        prestitoDAO.save(p4);
        prestitoDAO.save(p5);
        prestitoDAO.save(p6);
        prestitoDAO.save(p7);
        prestitoDAO.save(p8);
        prestitoDAO.save(p9);
        prestitoDAO.save(p10);*/

        //prendo i prestiti dal DB
        System.out.println("----RECUPERO I PRESTITI DAL DB-------");
        Prestito p1FromDB = null;
        Prestito p2FromDB = null;
        Prestito p3FromDB = null;
        Prestito p4FromDB = null;
        Prestito p5FromDB = null;
        Prestito p6FromDB = null;
        Prestito p7FromDB = null;
        Prestito p8FromDB = null;
        Prestito p9FromDB = null;
        Prestito p10FromDB = null;
        try {
            p1FromDB = prestitoDAO.getById(1L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            p2FromDB = prestitoDAO.getById(2L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            p3FromDB = prestitoDAO.getById(3L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            p4FromDB = prestitoDAO.getById(4L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            p5FromDB = prestitoDAO.getById(5L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            p6FromDB = prestitoDAO.getById(6L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            p7FromDB = prestitoDAO.getById(7L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            p8FromDB = prestitoDAO.getById(8L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            p9FromDB = prestitoDAO.getById(9L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            p10FromDB = prestitoDAO.getById(10L);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        // rimuovi dal catalogo con codice ISBN
        try {
            elementoDAO.delete("ISBN010");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }


        // ricerca per anno di pubblicazione
        System.out.println("----RICERCA PER ANNO DI PUBBLICAZIONE -------");

        elementoDAO.ricercaPerAnno(2024);

        // ricerca per autore
        System.out.println("----RICERCA PER AUTORE -------");
        try {
            elementoDAO.ricercaPerAutore("J.K. Rowling");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }


        //ricerca per titolo completo
        System.out.println("----RICERCA PER TITOLO COMPLETO -------");
        try {
            elementoDAO.ricercaPerTitolo("Il piccolo principe");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        // ricerca titolo parziale
        System.out.println("----RICERCA PER TITOLO PARZIALE -------");
        try {
            elementoDAO.ricercaPerTitolo("il picc");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }


        // ricerca elementi in prestito data n tessera
        System.out.println("----RICERCA ELEMENTI IN PRESTITO PER NUMERO DI TESSERA -------");
        try {
            prestitoDAO.elementiInPrestitoPerTessera("TESS001");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        // ricerca prestiti scaduti e non restituiti
        System.out.println("----RICERCA PRESTITI SCADUTI E NON RESTITUITI -------");

        prestitoDAO.prestitiScaduti();

    }

}
