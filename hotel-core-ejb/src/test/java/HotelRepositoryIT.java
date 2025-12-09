

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import ru.hotel.domain.entity.HotelEntity;
import ru.hotel.ejb.repository.HotelRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HotelRepositoryIT {

    private static EntityManagerFactory emf;

    private EntityManager em;
    private HotelRepository repository;

    @BeforeAll
    static void init() {
        // поднимаем JPA поверх того же persistence.xml
        emf = Persistence.createEntityManagerFactory("hotelPU");
    }

    @AfterAll
    static void close() {
        if (emf != null) {
            emf.close();
        }
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        repository = new HotelRepository();
        //repository.setEntityManager(em);

        em.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            //em.getTransaction().commit(); // Если хотим увидеть изменения в БД
        }
        em.close();
    }

    @Test
    void testSaveAndFindById() {
        HotelEntity hotel = new HotelEntity();
        hotel.setName("Test Hotel");
        hotel.setCategory("***");
        hotel.setNotes("Some notes");

        repository.save(hotel);
        // ID должен проставиться после persist/merge
        assertNotNull(hotel.getId());

        // сбросим контекст, чтобы гарантированно читать из БД
        em.flush();
        em.clear();

        HotelEntity fromDb = repository.findById(hotel.getId());
        assertNotNull(fromDb);
        assertEquals("Test Hotel", fromDb.getName());
        assertEquals("***", fromDb.getCategory());
    }

    @Test
    void testFindAll() {
        HotelEntity hotel1 = new HotelEntity();
        hotel1.setName("Hotel 1");
        hotel1.setCategory("**");

        HotelEntity hotel2 = new HotelEntity();
        hotel2.setName("Hotel 2");
        hotel2.setCategory("***");

        repository.save(hotel1);
        repository.save(hotel2);

        em.flush();
        em.clear();

        List<HotelEntity> all = repository.findAll();
        assertTrue(all.size() >= 2);
    }

}
